package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Pagination Inquiry Result
 */
@Data
@AllArgsConstructor
public class PageBean {
    private Integer total;
    private List rows;
}
