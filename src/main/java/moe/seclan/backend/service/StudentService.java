package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student getByUid(Integer uid);

    Integer delete(List<Integer> uids);

    Integer insert(Student student);

    Integer update(Student student);

    Student login(String studentId, String name);

    List<Student> get(String studentId, String name, String major, String schoolClass);
}
