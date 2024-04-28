package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
    private Integer questionId;
    private Integer questionType;
    private String content;
    private String correctAnswer;
}
