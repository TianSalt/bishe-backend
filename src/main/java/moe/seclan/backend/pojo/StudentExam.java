package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentExam {
    private Integer studentUid;
    private Integer examId;
    private Boolean presence;
}
