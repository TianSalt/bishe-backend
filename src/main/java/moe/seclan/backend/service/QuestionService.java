package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<Question> get(Integer questionId, Integer creator,
                       Integer questionType, String content);

    Question getById(Integer questionId);

    void insert(Question question);

    void update(Question question);

    void delete(Integer questionId);
}
