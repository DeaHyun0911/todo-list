package sparta.todo.service;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.dto.CommentResponseDto;
import sparta.todo.entity.Comment;
import sparta.todo.entity.Todo;
import sparta.todo.entity.User;
import sparta.todo.repository.CommentRepository;
import sparta.todo.repository.TodoRepository;
import sparta.todo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    public CommentResponseDto save(Long todoId, Long userId, String contents) {

        Todo todo = todoRepository.findByIdOrElseThrow(todoId);
        User user = userRepository.findByIdOrElseThrow(userId);

        Comment comment = new Comment(contents);
        comment.setTodo(todo);
        comment.setUser(user);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }

    public CommentResponseDto findById(Long id) {

        Comment comment = commentRepository.findByIdOrElseThrow(id);

        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto update(Long id, String contents) {

        Comment comment = commentRepository.findByIdOrElseThrow(id);
        comment.updateComment(contents);

        return new CommentResponseDto(comment);
    }

    public void delete(Long id) {
        Comment comment = commentRepository.findByIdOrElseThrow(id);
        commentRepository.delete(comment);
    }
}
