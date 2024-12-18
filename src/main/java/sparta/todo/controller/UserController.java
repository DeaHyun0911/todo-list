package sparta.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.todo.dto.UserRequestDto;
import sparta.todo.dto.UserResponseDto;
import sparta.todo.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto updatedUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updatedUser(id, userRequestDto.getUserName());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id,
                           @RequestBody UserRequestDto userRequestDto) {
        userService.deleteUser(id, userRequestDto.getPassword());
    }
}
