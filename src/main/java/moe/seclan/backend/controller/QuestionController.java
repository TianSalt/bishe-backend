package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public Result get(Integer questionId, Integer questionType, String content) {
        log.info("GET question with id {} and type {} and content {}", questionId, questionType, content);
        return Result.success(questionService.get(questionId, questionType, content));
    }

    @GetMapping("/{questionId}")
    public Result getByQuestionId(@PathVariable Integer questionId) {
        log.info("GET question with id {}", questionId);
        return Result.success(questionService.getByQuestionId(questionId));
    }
}