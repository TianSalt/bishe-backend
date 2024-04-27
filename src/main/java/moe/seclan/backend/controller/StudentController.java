package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping("/students")
    public Result getAll() {
        log.info("StudentController.getAll()");
        List<Student> studentList = studentService.getAll();
        return Result.success(studentList);
    }
}
