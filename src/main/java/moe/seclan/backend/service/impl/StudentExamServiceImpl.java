package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.StudentExamMapper;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.pojo.StudentExam;
import moe.seclan.backend.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentExamServiceImpl implements StudentExamService {

    @Autowired
    StudentExamMapper studentExamMapper;

    @Override
    public Boolean getPresence(Integer studentUid, Integer examId) {
        return studentExamMapper.getPresence(studentUid, examId);
    }

    @Override
    public List<Exam> getExamsOfStudent(Integer studentUid) {
        return studentExamMapper.getExamsOfStudent(studentUid);
    }

    @Override
    public void delete(Integer studentUid, Integer examId) {
        studentExamMapper.delete(studentUid, examId);
    }

    @Override
    public void insert(StudentExam studentExam) {
        if (studentExam.getPresence() == null)
            studentExam.setPresence(false);
        studentExamMapper.insert(studentExam);
    }

    @Override
    public void present(StudentExam studentExam) {
        studentExamMapper.present(studentExam);
    }

    @Override
    public List<Student> getStudentsInExam(Integer examId) {
        return studentExamMapper.getStudentsInExam(examId);
    }

    @Override
    public List<StudentExam> get(Integer studentUid, Integer examId, Boolean presence) {
        return studentExamMapper.get(studentUid, examId, presence);
    }

}
