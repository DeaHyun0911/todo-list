package sparta.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoRequestDto {

    private final Long id;

    @NotBlank
    @Size(max = 10)
    private final String title;

    @NotBlank
    private final String contents;

    public TodoRequestDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

}
