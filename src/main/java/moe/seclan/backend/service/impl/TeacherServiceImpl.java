package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.TeacherMapper;
import moe.seclan.backend.pojo.Teacher;
import moe.seclan.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }

    @Override
    public Teacher getByUid(Integer uid) {
        return teacherMapper.getByUid(uid);
    }

    @Override
    public void delete(Integer uid) {
        teacherMapper.delete(uid);
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

}
