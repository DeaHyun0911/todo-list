package sparta.todo.dto;

import lombok.Getter;
import sparta.todo.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;


    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
