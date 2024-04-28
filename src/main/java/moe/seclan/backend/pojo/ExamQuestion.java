package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamQuestion {
    private Integer questionIndex;
    private Integer examId;
    private Integer questionId;
    private Integer score;
}
