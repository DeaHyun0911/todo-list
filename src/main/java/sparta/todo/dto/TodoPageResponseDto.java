package sparta.todo.dto;

import lombok.Getter;
import sparta.todo.entity.Todo;

import java.time.LocalDateTime;

@Getter
public class TodoPageResponseDto {

    private final String title;

    private final String contents;

    private final int commentCount;

    private final String userName;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public TodoPageResponseDto(Todo todo, int commentCount) {
        this.userName = todo.getUser().getUserName();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.commentCount = commentCount;
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }

}
