package sparta.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.dto.TodoPageResponseDto;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.entity.Todo;
import sparta.todo.entity.User;
import sparta.todo.repository.TodoRepository;
import sparta.todo.repository.UserRepository;

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
        Todo todo = todoRepository.findByIdOrElseThrow(id);

        todoRepository.delete(todo);
    }

    public Page<TodoResponseDto> findTodoList(Pageable pageable) {
        Page<Todo> todoList = todoRepository.findAllByOrderByUpdatedAtDesc(pageable);
        return todoList.map(TodoResponseDto::toDto);
    }

//    public Page<TodoPageResponseDto> findTodoListV2(Pageable pageable) {
//        return todoRepository.findAllV2(pageable);
//    }

    public Page<TodoPageResponseDto> findTodoListV3(Pageable pageable) {
        Page<Todo> todos = todoRepository.findAllwithComments(pageable);

        List<TodoPageResponseDto> content = todos.stream()
                .map(todo -> new TodoPageResponseDto(todo, todo.getComments().size()))
                .toList();

        return new PageImpl<>(content, pageable, content.size());
    }

}
