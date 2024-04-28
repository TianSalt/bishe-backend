package moe.seclan.backend.service.impl;

import moe.seclan.backend.mapper.ExamMapper;
import moe.seclan.backend.pojo.Exam;
import moe.seclan.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> get(Integer examId, Integer creator, Boolean isPublished,
                          String examName, LocalDateTime fromTime, LocalDateTime toTime) {
        return examMapper.get(examId, creator, isPublished, examName, fromTime, toTime);
    }

    @Override
    public Exam getById(Integer examId) {
        return get(examId, null, null, null, null, null).get(0);
    }

    @Override
    public void delete(Integer id) {
        examMapper.delete(id);
    }

    @Override
    public void insert(Exam exam) {
        examMapper.insert(exam);
    }

    @Override
    public void update(Exam exam) {
        examMapper.update(exam);
    }

}
