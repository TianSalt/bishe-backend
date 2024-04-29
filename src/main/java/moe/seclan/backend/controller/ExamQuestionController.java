package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import moe.seclan.backend.pojo.ExamQuestion;

@Slf4j
@RestController
@RequestMapping("/exam-questions")
public class ExamQuestionController {

    @Autowired
    private ExamQuestionService examQuestionService;

    @GetMapping("/id-list")
    public Result getQuestionIdsOfExam(Integer examId) {
        log.info("GET question id list with exam id {}", examId);
        return Result.success(examQuestionService.getQuestionIdsOfExam(examId));
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

}
