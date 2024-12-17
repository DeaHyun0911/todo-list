package sparta.todo.exception;

public class ExistsEmailException extends RuntimeException {
    public ExistsEmailException() {
        super("이미 존재하는 이메일입니다.");
    }
}
