package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> getAll();

    Teacher getByUid(Integer uid);

    void delete(Integer uid);

    int insert(Teacher teacher);

    int update(Teacher teacher);

    Teacher login(String employeeId, String passwordHash);
}
