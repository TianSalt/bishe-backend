package moe.seclan.backend.service;

import moe.seclan.backend.pojo.PageBean;
import moe.seclan.backend.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    PageBean getPage(String studentId, String name, String major,
                     String schoolClass, Integer page, Integer size);

    Student getByUid(Integer uid);

    void delete(Integer uid);

    Integer insert(Student student);

    Integer update(Student student);

    Student login(String studentId, String name);
}
