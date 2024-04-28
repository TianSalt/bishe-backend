package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Exam {
    private Integer examId;
    private Integer creator;
    private Boolean isPublished;
    private String examName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String introduction;
}
