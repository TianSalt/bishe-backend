package moe.seclan.backend.service;

import moe.seclan.backend.pojo.StudentExamQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentExamQuestionService {


    void insert(StudentExamQuestion studentExamQuestion);

    void delete(Integer studentUid, Integer examId, Integer questionIndex);

    void update(StudentExamQuestion studentExamQuestion);

    List<StudentExamQuestion> get(Integer studentUid, Integer examId, Integer questionId);
}
