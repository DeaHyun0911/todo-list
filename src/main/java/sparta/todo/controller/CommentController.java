package sparta.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.todo.dto.CommentRequestDto;
import sparta.todo.dto.CommentResponseDto;
import sparta.todo.service.CommentService;

@Slf4j
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto saveComment(@Valid @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.save(
                commentRequestDto.getTodoId(),
                commentRequestDto.getUserId(),
                commentRequestDto.getContents()
        );
    }

    @GetMapping("/{id}")
    public CommentResponseDto findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.update(id, commentRequestDto.getContents());
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}
