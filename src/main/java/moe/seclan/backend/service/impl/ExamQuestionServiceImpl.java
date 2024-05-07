package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamQuestionMapper;
import moe.seclan.backend.mapper.QuestionMapper;
import moe.seclan.backend.pojo.ExamQuestion;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionsOfExam(Integer examId) {
        List<ExamQuestion> examQuestions = examQuestionMapper.get(examId, null);
        List<Question> questions = new ArrayList<>();
        for (ExamQuestion examQuestion : examQuestions) {
            Question question = questionMapper.getById(examQuestion.getQuestionId());
            question.setScore(examQuestion.getScore());
            questions.add(question);
        }
        return questions;
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
        if (examQuestion.getScore() == null)
            examQuestion.setScore(BigDecimal.ZERO);
        examQuestionMapper.update(examQuestion);
    }

    @Override
    public List<ExamQuestion> get(Integer examId, Integer questionIndex) {
        return examQuestionMapper.get(examId, questionIndex);
    }

}
