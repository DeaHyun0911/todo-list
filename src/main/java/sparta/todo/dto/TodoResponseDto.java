package sparta.todo.dto;

import lombok.Getter;
import sparta.todo.entity.Todo;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private final Long id;

    private final String userName;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUser().getUserName();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }
}
