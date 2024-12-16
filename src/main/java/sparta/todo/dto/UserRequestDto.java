package sparta.todo.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {

    private final String userName;

    private final String email;

    public UserRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
