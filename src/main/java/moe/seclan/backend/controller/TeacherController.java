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
    public Result getByUid(@PathVariable String uid) {
        log.info("GET teacher by uid: {}", uid);
        return Result.success(teacherService.getByUid(Integer.parseInt(uid)));
    }

    @PostMapping
    public Result insert(@RequestBody Teacher teacher) {
        log.info("POST teacher: {}", teacher);
        if (teacher.getEmployeeId() == null)
            return Result.error("Employee id is required");
        return Result.success(teacherService.insert(teacher));
    }

    @PutMapping
    public Result update(@RequestBody Teacher teacher) {
        log.info("PUT teacher: {}", teacher);
        return Result.success(teacherService.update(teacher));
    }

    @DeleteMapping("/{uid}")
    public Result delete(@PathVariable Integer uid) {
        log.info("DELETE teacher: {}", uid);
        teacherService.delete(uid);
        return Result.success();
    }

}
