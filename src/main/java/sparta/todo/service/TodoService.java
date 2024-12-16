package sparta.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.entity.Todo;
import sparta.todo.repository.TodoRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponseDto saveTodo(String title, String contents) {

        Todo savedTodo = todoRepository.save(new Todo(title, contents));

        return new TodoResponseDto(savedTodo);
    }

    public TodoResponseDto findById(Long id) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);

        return new TodoResponseDto(todo);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, String title, String contents) {
        Todo todo = todoRepository.findByIdOrElseThrow(id);

        todo.updateTodo(title, contents);

        return new TodoResponseDto(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
