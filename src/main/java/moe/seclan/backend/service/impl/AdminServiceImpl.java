package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.AdminMapper;
import moe.seclan.backend.pojo.Admin;
import moe.seclan.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String passwordHash) {
        return adminMapper.getByUsernameAndPassword(username, passwordHash);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.getAll();
    }

    @Override
    public Admin getByUid(Integer uid) {
        return adminMapper.getByUid(uid);
    }

    @Override
    public Integer insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }
}
