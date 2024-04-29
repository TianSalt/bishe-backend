package moe.seclan.backend.service.impl;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.mapper.StudentExamQuestionMapper;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.pojo.QuestionToMark;
import moe.seclan.backend.pojo.StudentExamQuestion;
import moe.seclan.backend.service.StudentExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class StudentExamQuestionServiceImpl implements StudentExamQuestionService {

    BigDecimal mark(StudentExamQuestion studentExamQuestion) {

        Question question = studentExamQuestionMapper.getQuestion(studentExamQuestion);
        BigDecimal score = studentExamQuestionMapper.getScore(studentExamQuestion);

        return new QuestionToMark(
                question.getQuestionType(),
                question.getCorrectAnswer(),
                studentExamQuestion.getAnswer(),
                score
        ).mark();
    }

    @Autowired
    StudentExamQuestionMapper studentExamQuestionMapper;

    @Override
    public void insert(StudentExamQuestion studentExamQuestion) {
        studentExamQuestion.setScore(mark(studentExamQuestion));
        studentExamQuestionMapper.insert(studentExamQuestion);
    }

    @Override
    public void delete(Integer studentUid, Integer examId, Integer questionIndex) {
        studentExamQuestionMapper.delete(studentUid, examId, questionIndex);
    }

    @Override
    public void update(StudentExamQuestion studentExamQuestion) {
        if (studentExamQuestion.getAnswer() != null)
            studentExamQuestion.setScore(mark(studentExamQuestion));
        studentExamQuestionMapper.update(studentExamQuestion);
    }

    @Override
    public List<StudentExamQuestion> get
            (Integer studentUid, Integer examId, Integer questionId) {
        return studentExamQuestionMapper.get(studentUid, examId, questionId);
    }
}
