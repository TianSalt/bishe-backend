package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {


    Admin login(String item1, String item2);

    List<Admin> getAll();

    Admin getByUid(Integer uid);

    Integer insert(Admin admin);

    int update(Admin admin);
}
