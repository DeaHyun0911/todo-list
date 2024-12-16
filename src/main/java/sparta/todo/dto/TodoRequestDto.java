package sparta.todo.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    private final Long id;

    private final String title;

    private final String contents;

    public TodoRequestDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

}
