package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.StudentExam;
import moe.seclan.backend.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/student-exams")
public class StudentExamController {

    @Autowired
    private StudentExamService studentExamService;

    @GetMapping("/{examId}")
    public Result getStudentsInExam(@PathVariable Integer examId) {
        log.info("getStudentsInExam examId: {}", examId);
        return Result.success(studentExamService.getStudentsInExam(examId));
    }

    @GetMapping
    public Result getPresence(Integer studentUid, Integer examId) {
        log.info("GET PRESENCE studentUid: {}, examId: {}", studentUid, examId);
        return Result.success(studentExamService.getPresence(studentUid, examId));
    }

    @GetMapping("/list")
    public Result getExamsOfStudent(Integer studentUid) {
        log.info("GET LIST studentUid: {}", studentUid);
        return Result.success(studentExamService.getExamsOfStudent(studentUid));
    }

    @DeleteMapping
    public Result delete(Integer studentUid, Integer examId) {
        log.info("DELETE uid: {}, examId: {}", studentUid, examId);
        studentExamService.delete(studentUid, examId);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody StudentExam studentExam) {
        log.info("INSERT studentExam: {}", studentExam);
        studentExamService.insert(studentExam);
        return Result.success();
    }

    @PutMapping
    public Result present(@RequestBody StudentExam studentExam) {
        log.info("PRESENT {}", studentExam);
        studentExamService.present(studentExam);
        return Result.success();
    }

}
