package sparta.todo.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private final String userName;

    private final String email;

    private final String password;

    public UserRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
