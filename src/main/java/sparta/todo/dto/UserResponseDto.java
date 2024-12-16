package sparta.todo.dto;

import lombok.Getter;
import sparta.todo.entity.User;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }
}
