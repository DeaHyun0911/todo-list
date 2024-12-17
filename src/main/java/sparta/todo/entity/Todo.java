package sparta.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public void setUser(User user) {
        this.user = user;
    }

}
