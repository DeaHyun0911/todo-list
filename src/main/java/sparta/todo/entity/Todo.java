package sparta.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Todo() {
    }

    public void updateTodo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
