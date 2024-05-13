package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
        log.info("GET student by uid: {}", uid);
        return Result.success(studentService.getByUid(uid));
    }

    @DeleteMapping("/{uids}")
    public Result delete(@PathVariable List<Integer> uids) {
        log.info("DELETE student with uid {}", uids);
        studentService.delete(uids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Student student) {
        log.info("ADD student {}", student);
        try {
            studentService.insert(student);
        } catch (Exception e) {
            return Result.error("该学号已存在或服务器异常");
        }
        return Result.success();
    }

    @PostMapping("/all")
    public Result insertAll(@RequestBody List<Student> students) {
        log.info("INSERT students {}", students);
        int succeed = 0, failed = 0;
        for (Student student : students) {
            try {
                studentService.insert(student);
            } catch (Exception e) {
                failed++;
                continue;
            }
            succeed++;
        }
        return Result.success("成功 " + succeed + " 个，失败 " + failed + " 个");
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("UPDATE student {}", student);
        try {
            studentService.update(student);
        } catch (Exception e) {
            return Result.error("该学号已存在或服务器异常");
        }
        return Result.success();
    }

}
