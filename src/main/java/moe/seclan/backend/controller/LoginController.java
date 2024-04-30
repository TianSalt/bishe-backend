package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Login;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.pojo.Teacher;
import moe.seclan.backend.service.StudentService;
import moe.seclan.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/teacher/login")
    public Result teacherLogin(@RequestBody Login login) {
        log.info("Login teacher: {}", login);
        Teacher teacher = teacherService.login(login.getItem1(), login.getItem2());
        if (teacher != null) {
            return Result.success(teacher.getUid());
        } else {
            return Result.error("工号或密码不正确");
        }
    }

    @PostMapping("/student/login")
    public Result studentLogin(@RequestBody Login login) {
        log.info("Login student {}", login);
        Student student = studentService.login(login.getItem1(), login.getItem2());
        if (student != null) {
            return Result.success(student.getUid());
        } else {
            return Result.error("找不到对应学生");
        }
    }

}
