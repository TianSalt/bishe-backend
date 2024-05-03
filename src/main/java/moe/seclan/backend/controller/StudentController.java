package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result get(String studentId, String name, String major, String schoolClass) {
        log.info("GET student by id: {}, name: {}, major: {}, schoolClass: {}",
                studentId, name, major, schoolClass);
        return Result.success(studentService.get(studentId, name, major, schoolClass));
    }

    @GetMapping("/{uid}")
    public Result getByUid(@PathVariable Integer uid) {
        log.info("GET student by id: {}", uid);
        return Result.success(studentService.getByUid(uid));
    }

    @DeleteMapping("/{uid}")
    public Result delete(@PathVariable Integer uid) {
        log.info("DELETE student with uid {}", uid);
        studentService.delete(uid);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Student student) {
        log.info("ADD student {}", student);
        if (student.getStudentId() == null)
            return Result.error("student id is null");
        return Result.success(studentService.insert(student));
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("UPDATE student {}", student);
        return Result.success(studentService.update(student));
    }

}
