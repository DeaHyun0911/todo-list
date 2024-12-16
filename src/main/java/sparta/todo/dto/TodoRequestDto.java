package sparta.todo.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    private final String title;

    private final String contents;

    public TodoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
