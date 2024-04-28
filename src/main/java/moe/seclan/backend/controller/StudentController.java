package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.PageBean;
import moe.seclan.backend.pojo.Result;
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
    public Result getPages(String name, String major, String schoolClass,
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "50") Integer size) {
        log.info("GET student by name: {}, major: {}, schoolClass: {}; page {} of {}",
                name, major, schoolClass, page, size);
        PageBean pageBean = studentService.getPages(name, major, schoolClass, page, size);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{studentId}")
    public Result delete(@PathVariable Integer studentId) {
        log.info("DELETE student with uid {}", studentId);
        studentService.delete(studentId);
        return Result.success();
    }

//    @PostMapping
//    public Result insert(@RequestBody Student student) {
//        log.info("ADD student {}", student);
//        studentService.insert(student);
//        return Result.success();
//    }

//    @PutMapping("/{studentId}")
//    public Result update(@PathVariable Integer studentId, @RequestBody Student student) {
//        log.info("UPDATE student with uid {}", studentId);
//        studentService.update()
//    }

}
