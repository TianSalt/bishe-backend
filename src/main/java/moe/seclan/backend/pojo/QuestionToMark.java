package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class QuestionToMark {
    /**
     * 0: Single Choice
     * 1: Multiple Choice
     * 2: Fill-in-the-blank with one blank
     */
    private Integer questionType;
    private String correctAnswer;
    private String studentAnswer;
    private BigDecimal score;

    public BigDecimal mark() {
        if (questionType == 0)
            return correctAnswer.equals(studentAnswer) ? score : BigDecimal.ZERO;
        else if (questionType == 2)
            return correctAnswer.equals(studentAnswer) ? score : BigDecimal.ZERO;
        else return null;
    }

}
