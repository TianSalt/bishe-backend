package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.StudentMapper;
import moe.seclan.backend.pojo.Student;
import moe.seclan.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getByUid(Integer uid) {
        return studentMapper.getByUid(uid);
    }

    @Override
    public void delete(Integer uid) {
        studentMapper.delete(uid);
    }

    @Override
    public Integer insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Integer update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student login(String studentId, String name) {
        return studentMapper.getBySidAndName(studentId, name);
    }

    @Override
    public List<Student> get(String studentId, String name, String major, String schoolClass) {
        return studentMapper.get(studentId, name, major, schoolClass);
    }

}
