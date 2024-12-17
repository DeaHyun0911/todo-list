package sparta.todo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank
    @Size(max = 4)
    private final String userName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "이메일형식이 아닙니다.")
    private final String email;

    @NotBlank
    private final String password;

    public UserRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
