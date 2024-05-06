package moe.seclan.backend.controller;

import lombok.extern.slf4j.Slf4j;
import moe.seclan.backend.pojo.Admin;
import moe.seclan.backend.pojo.Result;
import moe.seclan.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public Result getAllAdmins() {
        log.info("getAllAdmins");
        return Result.success(adminService.getAll());
    }

    @GetMapping("/{uid}")
    public Result getByUid(@PathVariable Integer uid) {
        log.info("get by uid: {}", uid);
        return Result.success(adminService.getByUid(uid));
    }

    @PostMapping
    public Result insert(Admin admin) {
        log.info("insert: {}", admin);
        if (adminService.insert(admin) == 0)
            return Result.error("该用户名已存在");
        else return Result.success();
    }

    public Result update(Admin admin) {
        log.info("update: {}", admin);
        if (adminService.update(admin) == 0)
            return Result.error("该用户名已存在");
        else return Result.success();
    }

}
