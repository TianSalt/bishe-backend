package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.*;
import moe.seclan.backend.service.AdminService;
import moe.seclan.backend.service.StudentService;
import moe.seclan.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/teacher-login")
    public Result teacherLogin(@RequestBody Login loginInput) {
        log.info("Login teacher: {} {}", loginInput.getItem1(), loginInput.getItem2());
        if (Objects.equals(loginInput.getItem1(), ""))
            return Result.error("工号或密码不正确");
        Teacher teacher = teacherService.login(loginInput.getItem1(), loginInput.getItem2());
        if (teacher != null) {
            Integer uid = teacher.getUid();
            return Result.success(new LoginResponse(uid, JwtUtil.createToken(uid, "teacher")));
        } else {
            return Result.error("工号或密码不正确");
        }
    }

    @PostMapping("/admin-login")
    public Result adminLogin(@RequestBody Login loginInput) {
        log.info("Login admin: {} {}", loginInput.getItem1(), loginInput.getItem2());
        if (Objects.equals(loginInput.getItem1(), ""))
            return Result.error("用户名或密码不正确");
        Admin admin = adminService.login(loginInput.getItem1(), loginInput.getItem2());
        if (admin != null) {
            Integer uid = admin.getUid();
            return Result.success(new LoginResponse(uid, JwtUtil.createToken(uid, "admin")));
        } else {
            return Result.error("用户名或密码不正确");
        }
    }

    @PostMapping("/student-login")
    public Result studentLogin(@RequestBody Login loginInput) {
        log.info("Login student {} {}", loginInput.getItem1(), loginInput.getItem2());
        if (Objects.equals(loginInput.getItem1(), ""))
            return Result.error("姓名或学号不正确");
        Student student = studentService.login(loginInput.getItem1(), loginInput.getItem2());
        if (student != null) {
            Integer uid = student.getUid();
            return Result.success(new LoginResponse(uid, JwtUtil.createToken(uid, "student")));
        } else {
            return Result.error("姓名或学号不正确");
        }
    }


    @GetMapping("/check-token")
    public Result checkToken(String token) {
        log.info("Check token: {}", token);
        if (JwtUtil.checkToken(token)) return Result.success();
        else return Result.error("Invalid token.");
    }

}
