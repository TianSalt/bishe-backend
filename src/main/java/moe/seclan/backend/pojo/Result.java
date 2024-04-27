package moe.seclan.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private Integer code; // Response code: 1 for success, 0 for failure
    private String msg;  // Response message (description string)
    private Object data; // Returned data

    // Successful response for create, update, or delete operations
    public static Result success() {
        return new Result(1, "success", null);
    }

    // Successful response for query operations
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    // Error response
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}
