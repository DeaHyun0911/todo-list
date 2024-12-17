package sparta.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Comment extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo ;

    private String contents;

    public Comment(String contents) {
        this.contents = contents;
    }

    public Comment() {
    }

    public void updateComment(String contents) {
        this.contents = contents;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTodo(Todo todo) { this.todo = todo; }
}
