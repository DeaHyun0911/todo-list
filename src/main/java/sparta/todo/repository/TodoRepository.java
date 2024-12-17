package sparta.todo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sparta.todo.dto.TodoPageResponseDto;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.entity.Todo;

import java.util.NoSuchElementException;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 일정 입니다."));
    }

    Page<Todo> findAllByOrderByUpdatedAtDesc(Pageable pageable);

    @Query("SELECT new sparta.todo.dto.TodoPageResponseDto(t, COUNT(c)) " +
            "FROM Todo t LEFT JOIN Comment c ON t.id = c.todo.id " +
            "GROUP BY t.id, t.title, t.contents, t.user, t.createdAt, t.updatedAt " +
            "ORDER BY t.updatedAt DESC")
    Page<TodoPageResponseDto> findAllV2(Pageable pageable);

}
