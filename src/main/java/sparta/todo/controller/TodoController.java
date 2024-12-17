package sparta.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import sparta.todo.dto.TodoPageResponseDto;
import sparta.todo.dto.TodoRequestDto;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.repository.TodoRepository;
import sparta.todo.service.TodoService;

import java.util.List;


@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponseDto saveTodo(@Valid @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.saveTodo(todoRequestDto.getId(), todoRequestDto.getTitle(), todoRequestDto.getContents());
    }

    @GetMapping("/{id}")
    public TodoResponseDto findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping
    public Page<TodoResponseDto> findTodoList(@PageableDefault(size = 10) Pageable pageable) {
        return todoService.findTodoList(pageable);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id,
                                      @Valid @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(id, todoRequestDto.getTitle(), todoRequestDto.getContents());
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
