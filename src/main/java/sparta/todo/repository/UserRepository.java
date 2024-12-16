package sparta.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
