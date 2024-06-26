package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer questionId;
    private Integer creator;
    private Integer questionType;
    private String content;
    private String correctAnswer;

    private String creatorName;
    private BigDecimal score;

    public Question(Integer questionId, Integer creator, Integer questionType, String content, String correctAnswer) {
        this.questionId = questionId;
        this.creator = creator;
        this.questionType = questionType;
        this.content = content;
        this.correctAnswer = correctAnswer;
    }

}
