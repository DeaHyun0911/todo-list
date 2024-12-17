package sparta.todo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class MyExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResult handleNoSuchElementException(NoSuchElementException e) {
        return new ErrorResult("404 NOT_FOUND", e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(PasswordMismatchException.class)
    public ErrorResult handlePasswordMismatchException(PasswordMismatchException e) {
        return new ErrorResult("401 UNAUTHORIZED", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors()
                .stream().map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse(null);

        return new ErrorResult("400 BAD_REQUEST", message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExistsEmailException.class)
    public ErrorResult handleExistsEmailException(ExistsEmailException e) {
        return new ErrorResult("400 BAD_REQUEST", e.getMessage());
    }

}
