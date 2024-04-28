package moe.seclan.backend.service;

import moe.seclan.backend.pojo.Exam;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ExamService {

    List<Exam> get(Integer examId, Integer creator, Boolean isPublished,
                   String examName, LocalDateTime fromTime, LocalDateTime toTime);

    Exam getById(Integer examId);

    void delete(Integer examId);

    void insert(Exam exam);

    void update(Exam exam);

}
