package sparta.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Column(unique = true)
    private String email;

    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }

}
