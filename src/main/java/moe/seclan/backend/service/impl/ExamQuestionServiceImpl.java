package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamQuestionMapper;
import moe.seclan.backend.mapper.QuestionMapper;
import moe.seclan.backend.pojo.ExamQuestion;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Question getQuestionById(Integer questionId) {
        return questionMapper.get(questionId, null, null).get(0);
    }

    @Override
    public List<Integer> getQuestionIdsOfExam(Integer examId) {
        return examQuestionMapper.getQuestionIdsOfExam(examId);
    }

    @Override
    public List<Question> getQuestionsOfExam(Integer examId) {
        List<Integer> questionIdsOfExam = examQuestionMapper.getQuestionIdsOfExam(examId);
        return questionIdsOfExam.stream().map(this::getQuestionById).toList();
    }

    @Override
    public void insert(ExamQuestion examQuestion) {
        examQuestionMapper.insert(examQuestion);
    }

}
