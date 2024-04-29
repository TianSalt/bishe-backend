package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.StudentExam;
import moe.seclan.backend.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/student-exams")
public class StudentExamController {

    @Autowired
    private StudentExamService studentExamService;

    @GetMapping
    public Result getPresence(Integer studentId, Integer examId) {
        log.info("GET PRESENCE studentId: {}, examId: {}", studentId, examId);
        return Result.success(studentExamService.getPresence(studentId, examId));
    }

    @DeleteMapping
    public Result delete(Integer studentId, Integer examId) {
        log.info("DELETE studentId: {}, examId: {}", studentId, examId);
        studentExamService.delete(studentId, examId);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody StudentExam studentExam) {
        log.info("INSERT studentExam: {}", studentExam);
        studentExamService.insert(studentExam);
        return Result.success();
    }
}
