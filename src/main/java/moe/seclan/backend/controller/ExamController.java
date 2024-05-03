package moe.seclan.backend.controller;


import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public Result get(Integer examId, Integer creator, Boolean isPublished,
                      String title, LocalDateTime fromTime, LocalDateTime toTime) {
        log.info("GET exam by {}, {}, {}, {}, {}, {}",
                examId, creator, isPublished, title, fromTime, toTime);
        List<Exam> list = examService.get(examId, creator, isPublished, title, fromTime, toTime);
        return Result.success(list);
    }

    @GetMapping("/{examId}")
    public Result getById(@PathVariable Integer examId) {
        log.info("GET exam by {}", examId);
        return Result.success(examService.getById(examId));
    }

    @DeleteMapping("/{examId}")
    public Result delete(@PathVariable Integer examId) {
        log.info("DELETE exam with id {}", examId);
        examService.delete(examId);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Exam exam) {
        log.info("ADD exam {}", exam);
        examService.insert(exam);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Exam exam) {
        log.info("UPDATE exam {}", exam);
        examService.update(exam);
        return Result.success();
    }
}
