package moe.seclan.backend.controller;


import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Result getAll() {
        log.info("GET all teachers");
        return Result.success(teacherService.getAll());
    }

    @GetMapping("/{uid}")
    public Result getByUid(@PathVariable Integer uid) {
        log.info("GET teacher by uid: {}", uid);
        return Result.success(teacherService.getByUid(uid));
    }

}
