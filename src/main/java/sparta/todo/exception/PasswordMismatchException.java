package sparta.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PasswordMismatchException extends ResponseStatusException {
    public PasswordMismatchException() {
        super(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
    }
}
