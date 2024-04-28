package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Exam {
    private Integer examId;
    private Integer creator;
    private Boolean isPublished;
    private String examName;
    private Timestamp startTime;
    private Timestamp endTime;
    private Boolean isEncrypted;
    private String passwordHash; // MD5
    private String introduction;
    private String comment;
}
