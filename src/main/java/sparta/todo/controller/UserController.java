package sparta.todo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.todo.dto.LoginRequestDto;
import sparta.todo.dto.LoginResponseDto;
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
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
