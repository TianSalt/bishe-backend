package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Question;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public Result get(Integer questionId, Integer creator,
                      Integer questionType, String content) {
        log.info("GET question with id {}, creator {}, type {}, content {}",
                questionId, creator, questionType, content);
        return Result.success(questionService.get(questionId, creator, questionType, content));
    }

    @GetMapping("/{questionId}")
    public Result getById(@PathVariable Integer questionId) {
        log.info("GET question with id {}", questionId);
        return Result.success(questionService.getById(questionId));
    }

    @PostMapping
    public Result insert(@RequestBody Question question) {
        log.info("INSERT question {}", question);
        questionService.insert(question);
        return Result.success();
    }

    @DeleteMapping("/{questionId}")
    public Result delete(@PathVariable Integer questionId) {
        log.info("DELETE question with id {}", questionId);
        questionService.delete(questionId);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Question question) {
        log.info("UPDATE question {}", question);
        questionService.update(question);
        return Result.success();
    }

}
