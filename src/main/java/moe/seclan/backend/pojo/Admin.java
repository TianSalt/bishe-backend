package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin {
    private Integer uid;
    private String username;
    private String passwordHash;
}
