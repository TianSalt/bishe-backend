package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.pojo.StudentExam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentExamService {

    Boolean getPresence(Integer studentUid, Integer examId);

    List<Exam> getExamsOfStudent(Integer studentUid);

    void delete(Integer studentUid, Integer examId);

    void insert(StudentExam studentExam);

    void present(StudentExam studentExam);

    List<Student> getStudentsInExam(Integer examId);
}
