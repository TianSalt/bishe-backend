package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentExamQuestion {
    private Integer studentId;
    private Integer examId;
    private Integer questionId;
    private String answer;
    private Integer score;
}
