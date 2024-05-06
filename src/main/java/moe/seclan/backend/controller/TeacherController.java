package moe.seclan.backend.controller;


import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.pojo.Teacher;
import moe.seclan.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @PostMapping
    public Result insert(@RequestBody Teacher teacher) {
        log.info("POST teacher: {}", teacher);
        if (teacherService.insert(teacher) == 0)
            return Result.error("该工号已存在");
        else return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Teacher teacher) {
        log.info("PUT teacher: {}", teacher);
        if (teacherService.update(teacher) == 0)
            return Result.error("该工号已存在");
        else return Result.success();
    }

    @DeleteMapping("/{uid}")
    public Result delete(@PathVariable Integer uid) {
        log.info("DELETE teacher: {}", uid);
        teacherService.delete(uid);
        return Result.success();
    }

}
