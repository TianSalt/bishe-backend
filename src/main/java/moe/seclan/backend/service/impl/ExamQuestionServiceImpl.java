package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamQuestionMapper;
import moe.seclan.backend.mapper.QuestionMapper;
import moe.seclan.backend.pojo.ExamQuestion;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionsOfExam(Integer examId) {
        List<Integer> questionIdsOfExam = examQuestionMapper.getQuestionIdsOfExam(examId);
        return questionIdsOfExam.stream().map(questionMapper::getById).toList();
    }

    @Override
    public void insert(ExamQuestion examQuestion) {
        if (examQuestion.getScore() == null)
            examQuestion.setScore(BigDecimal.ZERO);
        examQuestionMapper.insert(examQuestion);
    }

    @Override
    public void delete(Integer examId, Integer questionIndex) {
        examQuestionMapper.delete(examId, questionIndex);
    }

    @Override
    public void update(ExamQuestion examQuestion) {
        examQuestionMapper.update(examQuestion);
    }

    @Override
    public List<ExamQuestion> get(Integer examId, Integer questionIndex) {
        return examQuestionMapper.get(examId, questionIndex);
    }

}
