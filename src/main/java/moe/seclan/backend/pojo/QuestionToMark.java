package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class QuestionToMark {
    /**
     * 0: Single Choice
     * 1: Multiple Choice
     * 2: Fill-in-the-blank with one blank
     * 3: Fill-in-the-blank with multiple blanks
     * 4: Programming
     * 5: Short answer (subjective)
     */
    private Integer questionType;
    private String correctAnswer;
    private String studentAnswer;
    private BigDecimal fullMark;

    public BigDecimal mark() {
        if (questionType == 0 || questionType == 1)
            return correctAnswer.equals(studentAnswer) ? fullMark : BigDecimal.ZERO;
        else if (questionType == 2)
            return correctAnswer.equals(studentAnswer) ? fullMark : BigDecimal.ZERO;
        else if (questionType == 3) {
            return fullMark.multiply(BigDecimal.valueOf(onlineJudge(studentAnswer, correctAnswer)));
        } else {
            return null;
        }
    }

    public double onlineJudge(String code, String testData) {
        return 0;
    }

}
