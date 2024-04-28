package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<Question> get(Integer questionId, Integer questionType, String content);

    Question getByQuestionId(Integer questionId);

    void insert(Question question);

    void update(Question question);

    void delete(Integer questionId);
}
