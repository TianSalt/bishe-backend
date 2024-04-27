package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAll();
}
