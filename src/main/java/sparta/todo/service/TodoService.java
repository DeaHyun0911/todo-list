package sparta.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.entity.Todo;
import sparta.todo.entity.User;
import sparta.todo.repository.TodoRepository;
import sparta.todo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoResponseDto saveTodo(Long id, String title, String contents) {

        User findUser = userRepository.findByIdOrElseThrow(id);
        Todo todo = new Todo(title, contents);
        todo.setUser(findUser);
        Todo savedTodo = todoRepository.save(todo);

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

    public List<TodoResponseDto> findTodoList() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDto::toDto)
                .toList();
    }
}
