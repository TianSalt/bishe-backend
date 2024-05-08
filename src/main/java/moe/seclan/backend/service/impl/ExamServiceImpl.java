package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamMapper;
import moe.seclan.backend.mapper.TeacherMapper;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Teacher;
import moe.seclan.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private TeacherMapper teacherMapper;

//    private LocalDateTime gmtToLocal(LocalDateTime gmtDateTime) {
//        ZoneId currentZone = ZoneId.systemDefault();
//        ZonedDateTime currentZonedDateTime = gmtDateTime.atZone(ZoneId.of("GMT"))
//                .withZoneSameInstant(currentZone);
//        return currentZonedDateTime.toLocalDateTime();
//    }

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> get(Integer examId, Integer creator, Boolean isPublished,
                          String title, LocalDateTime fromTime, LocalDateTime toTime) {
        List<Exam> exams = examMapper.get(examId, creator, isPublished, title, fromTime, toTime);
        List<Exam> finalExams = new ArrayList<>();
        for (Exam exam : exams) {
            Exam newExam = new Exam(exam);
            Teacher creatorTeacher = teacherMapper.getByUid(exam.getCreator());
            newExam.setCreatorName(creatorTeacher.getName());
            finalExams.add(newExam);
        }
        return finalExams;
    }

    @Override
    public Exam getById(Integer examId) {
        return get(examId, null, null, null, null, null).get(0);
    }

    @Override
    public void delete(Integer id) {
        examMapper.delete(id);
    }

    @Override
    public void insert(Exam exam) {
        if (exam.getIsPublished() == null)
            exam.setIsPublished(false);
        examMapper.insert(exam);
    }

    @Override
    public void update(Exam exam) {
        examMapper.update(exam);
    }

}
