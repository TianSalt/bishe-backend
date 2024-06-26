package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer uid;
    private String studentId;
    private String name;
    private String major;
    private String schoolClass;
}
