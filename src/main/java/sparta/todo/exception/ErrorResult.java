package sparta.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResult {
    private LocalDateTime timestamp;
    private String code;
    private String message;

    public ErrorResult(String code, String message) {
        this.timestamp = LocalDateTime.now();
        this.code = code;
        this.message = message;
    }
}


