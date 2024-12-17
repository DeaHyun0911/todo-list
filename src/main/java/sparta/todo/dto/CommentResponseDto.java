package sparta.todo.dto;

import lombok.Getter;
import sparta.todo.entity.Comment;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private final Long id;

    private final Long todoId;

    private final Long userId;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.todoId = comment.getTodo().getId();
        this.userId = comment.getUser().getId();
        this.contents = comment.getContents();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
