package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentExamQuestion {
    private Integer studentUid;
    private Integer examId;
    private Integer questionIndex;
    private String answer;
    private java.math.BigDecimal score;
}
