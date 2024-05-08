package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.StudentExamQuestion;
import moe.seclan.backend.service.StudentExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/student-exam-questions")
public class StudentExamQuestionController {

    @Autowired
    private StudentExamQuestionService studentExamQuestionService;

    @PostMapping
    public Result answer(@RequestBody StudentExamQuestion studentExamQuestion) {
        log.info("ANSWERS: {}", studentExamQuestion);
        studentExamQuestionService.answer(studentExamQuestion);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer studentUid, Integer examId, Integer questionId) {
        log.info("DELETE question {} in exam {} taken by uid {}",
                questionId, examId, studentUid);
        studentExamQuestionService.delete(studentUid, examId, questionId);
        return Result.success();
    }

//    @PutMapping
//    public Result update(@RequestBody StudentExamQuestion studentExamQuestion) {
//        log.info("UPDATE {}", studentExamQuestion);
//        studentExamQuestionService.update(studentExamQuestion);
//        return Result.success();
//    }

    @GetMapping
    public Result get(Integer studentUid, Integer examId, Integer questionIndex) {
        log.info("GET question {} in exam {} by taken uid {}",
                questionIndex, examId, studentUid);
        List<StudentExamQuestion> list
                =  studentExamQuestionService.get(studentUid, examId, questionIndex);
        return Result.success(list);
    }

    @GetMapping("/sum-score")
    public Result sumScore(Integer studentUid, Integer examId) {
        log.info("sum-score uid {} in exam {}", studentUid, examId);
        BigDecimal sum = studentExamQuestionService.sumScore(studentUid, examId);
        log.info("sum-score score: {}", sum);
        return Result.success(sum);
    }

}
