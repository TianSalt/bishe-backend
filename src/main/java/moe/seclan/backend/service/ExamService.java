package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    List<Exam> getAll();

//    List<Exam> getByTeacherUid(Integer teacherUid);

    void delete(Integer examId);

    void insert(Exam exam);

    void update(Integer examId, Exam exam);

}
