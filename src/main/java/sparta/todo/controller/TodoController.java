package sparta.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.todo.dto.TodoRequestDto;
import sparta.todo.dto.TodoResponseDto;
import sparta.todo.repository.TodoRepository;
import sparta.todo.service.TodoService;


@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoResponseDto saveTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.saveTodo(todoRequestDto.getTitle(), todoRequestDto.getContents());
    }

    @GetMapping("/{id}")
    public TodoResponseDto findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id,
                                      @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(id, todoRequestDto.getTitle(), todoRequestDto.getContents());
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
