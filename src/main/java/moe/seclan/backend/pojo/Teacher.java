package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    private Integer uid;
    private String employeeId;
    private String name;
    private String passwordHash; // MD5
}
