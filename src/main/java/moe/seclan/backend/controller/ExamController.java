package moe.seclan.backend.controller;


import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public Result getAll() {
        log.info("GET all exams");
        return Result.success(examService.getAll());
    }

//    @GetMapping("/{teacherUid}")
//    public Result getByTeacherUid(@PathVariable("teacherUid") Integer teacherUid) {
//        log.info("GET by teacher uid: {}", teacherUid);
//        List<Exam> list = examService.getByTeacherUid(teacherUid);
//        return Result.success(list);
//    }

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

    @PutMapping("/{examId}")
    public Result update(@PathVariable Integer examId, @RequestBody Exam exam) {
        log.info("UPDATE exam with id {} to {}", examId, exam);
        examService.update(examId, exam);
        return Result.success();
    }

}
