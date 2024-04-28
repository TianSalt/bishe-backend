package moe.seclan.backend.service;

import moe.seclan.backend.pojo.PageBean;
import moe.seclan.backend.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    PageBean getPages(String name, String major, String schoolClass, Integer page, Integer size);

    void delete(Integer studentId);

    void insert(Student student);
}
