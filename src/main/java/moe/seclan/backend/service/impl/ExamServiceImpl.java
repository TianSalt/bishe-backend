package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamMapper;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> getAll() {
        return examMapper.getAll();
    }

//    @Override
//    public List<Exam> getByTeacherUid(Integer teacherUid) {
//        return examMapper.getByTeacherUid(teacherUid);
//    }

    @Override
    public void delete(Integer id) {
        examMapper.delete(id);
    }

    @Override
    public void insert(Exam exam) {
        examMapper.insert(exam);
    }

    @Override
    public void update(Integer id, Exam exam) {
        examMapper.update(id ,exam);
    }

}
