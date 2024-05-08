package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private Integer examId;
    private Integer creator;
    private Boolean isPublished;
    private String title;
    private LocalDateTime startTime; // GMT
    private LocalDateTime endTime; // GMT
    private String introduction;
    private String creatorName;


    public Exam(Integer examId, Integer creator, Boolean isPublished, String title, LocalDateTime startTime, LocalDateTime endTime, String introduction) {
        this.examId = examId;
        this.creator = creator;
        this.isPublished = isPublished;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.introduction = introduction;
    }

    public Exam(Exam exam) {
        this.examId = exam.getExamId();
        this.creator = exam.getCreator();
        this.creatorName = exam.getCreatorName();
        this.isPublished = exam.getIsPublished();
        this.title = exam.getTitle();
        this.startTime = exam.getStartTime();
        this.endTime = exam.getEndTime();
        this.introduction = exam.getIntroduction();
    }
}
