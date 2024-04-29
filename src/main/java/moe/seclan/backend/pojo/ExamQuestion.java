package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamQuestion {
    private Integer examId;
    private Integer questionIndex;
    private Integer questionId;
    private java.math.BigDecimal score;
}
