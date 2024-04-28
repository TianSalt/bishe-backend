package moe.seclan.backend.service;

import moe.seclan.backend.pojo.StudentExam;
import org.springframework.stereotype.Service;

@Service
public interface StudentExamService {

    Boolean getPresence(Integer studentId, Integer examId);

    void delete(Integer studentId, Integer examId);

    void insert(StudentExam studentExam);
}
