package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.StudentExam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentExamService {

    Boolean getPresence(Integer studentId, Integer examId);

    List<Exam> getExamsOfStudent(Integer studentId);

    void delete(Integer studentId, Integer examId);

    void insert(StudentExam studentExam);

    void present(StudentExam studentExam);
}
