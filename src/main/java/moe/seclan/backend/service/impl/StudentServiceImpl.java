package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.StudentMapper;
import moe.seclan.backend.pojo.PageBean;
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
    public PageBean getPages(String studentId, String name, String major, String schoolClass, Integer page, Integer size) {
        Integer count = studentMapper.count();
        List<Student> studentList = studentMapper.getPages(studentId, name, major, schoolClass, (page - 1) * size, size);
        return new PageBean(count, studentList);
    }

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


}
