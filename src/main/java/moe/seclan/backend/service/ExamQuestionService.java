package moe.seclan.backend.service;

import moe.seclan.backend.pojo.ExamQuestion;
import moe.seclan.backend.pojo.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamQuestionService {

    List<Question> getQuestionsOfExam(Integer examId);

    void insert(ExamQuestion examQuestion);

    void delete(Integer examId, Integer questionIndex);

    void update(ExamQuestion examQuestion);
}
