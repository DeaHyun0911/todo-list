package sparta.todo.dto;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final String email;

    private final String sessionId;

    public LoginResponseDto(String email, String sessionId) {
        this.email = email;
        this.sessionId = sessionId;
    }
}