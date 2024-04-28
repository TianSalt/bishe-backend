package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.QuestionMapper;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> get(Integer questionId, Integer questionType, String content) {
        return questionMapper.get(questionId, questionType, content);
    }

    @Override
    public Question getByQuestionId(Integer questionId) {
        return questionMapper.get(questionId, null, null).get(0);
    }


    @Override
    public void insert(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public void update(Question question) {
        questionMapper.update(question);
    }

    @Override
    public void delete(Integer questionId) {
        questionMapper.delete(questionId);
    }
}
