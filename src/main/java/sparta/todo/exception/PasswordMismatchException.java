package sparta.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
