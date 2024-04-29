package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.StudentExamMapper;
import moe.seclan.backend.pojo.StudentExam;
import moe.seclan.backend.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentExamServiceImpl implements StudentExamService {

    @Autowired
    StudentExamMapper studentExamMapper;

    @Override
    public Boolean getPresence(Integer studentId, Integer examId) {
        return studentExamMapper.getPresence(studentId, examId);
    }

    @Override
    public void delete(Integer studentId, Integer examId) {
        studentExamMapper.delete(studentId, examId);
    }

    @Override
    public void insert(StudentExam studentExam) {
        if (studentExam.getPresence() == null)
            studentExam.setPresence(false);
        studentExamMapper.insert(studentExam);
    }

}
