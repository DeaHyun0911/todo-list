package sparta.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    private final Long todoId;

    private final Long userId;

    @NotBlank
    private final String contents;

    public CommentRequestDto(Long todoId, Long userId, String contents) {
        this.todoId = todoId;
        this.userId = userId;
        this.contents = contents;
    }
}
