package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import moe.seclan.backend.pojo.ExamQuestion;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/exam-questions")
public class ExamQuestionController {

    @Autowired
    private ExamQuestionService examQuestionService;

    @GetMapping
    public Result getExamQuestions(Integer examId, Integer questionIndex) {
        log.info("getExamQuestions examId={}, questionIndex={}", examId, questionIndex);
        return Result.success(examQuestionService.get(examId, questionIndex));
    }

    @GetMapping("/no-answer-list")
    public Result getQuestionsOfExamWithoutAnswer(Integer examId) {
        log.info("GET question list with exam id {} without answer", examId);
        List<Question> questions = examQuestionService.getQuestionsOfExam(examId);
        for (Question question : questions) {
            question.setCorrectAnswer(null);
        }
        return Result.success(questions);
    }

    @GetMapping("/list")
    public Result getQuestionsOfExam(Integer examId) {
        log.info("GET question list with exam id {}", examId);
        return Result.success(examQuestionService.getQuestionsOfExam(examId));
    }

    @PostMapping
    public Result insert(@RequestBody ExamQuestion examQuestion) {
        log.info("INSERT exam_question {}", examQuestion);
        examQuestionService.insert(examQuestion);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer examId, Integer questionIndex) {
        log.info("DELETE exam_question with id {} and question id {}", examId, questionIndex);
        examQuestionService.delete(examId, questionIndex);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ExamQuestion examQuestion) {
        log.info("UPDATE exam_question {}", examQuestion);
        examQuestionService.update(examQuestion);
        return Result.success();
    }

}
