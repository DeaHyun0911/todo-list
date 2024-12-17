package sparta.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.todo.entity.Comment;
import sparta.todo.entity.Todo;

import java.util.NoSuchElementException;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    default Comment findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 댓글 입니다."));
    }

    Long countByTodoId(Long todoId);
}
