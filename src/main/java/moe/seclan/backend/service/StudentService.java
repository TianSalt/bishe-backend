package moe.seclan.backend.service;

import moe.seclan.backend.pojo.PageBean;
import moe.seclan.backend.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    PageBean getPages(String studentId, String name, String major, String schoolClass, Integer page, Integer size);

    Student getStudent(Integer uid);

    void delete(Integer uid);

    Integer insert(Student student);

    Integer update(Student student);

}
