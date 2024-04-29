package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.StudentExamQuestion;
import moe.seclan.backend.service.StudentExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student-exam-questions")
public class StudentExamQuestionController {

    @Autowired
    private StudentExamQuestionService studentExamQuestionService;

    @PostMapping
    public Result insert(@RequestBody StudentExamQuestion studentExamQuestion) {
        log.info("INSERT studentExamQuestion: {}", studentExamQuestion);
        studentExamQuestionService.insert(studentExamQuestion);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer studentUid, Integer examId, Integer questionId) {
        log.info("DELETE question {} in exam {} taken by uid {}",
                questionId, examId, studentUid);
        studentExamQuestionService.delete(studentUid, examId, questionId);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody StudentExamQuestion studentExamQuestion) {
        log.info("UPDATE {}", studentExamQuestion);
        studentExamQuestionService.update(studentExamQuestion);
        return Result.success();
    }

    @GetMapping
    public Result get(Integer studentUid, Integer examId, Integer questionId) {
        log.info("GET question {} in exam {} by taken uid {}",
                questionId, examId, studentUid);
        List<StudentExamQuestion> list
                =  studentExamQuestionService.get(studentUid, examId, questionId);
        return Result.success(list);
    }

}
