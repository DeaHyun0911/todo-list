package sparta.todo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.todo.dto.LoginRequestDto;
import sparta.todo.dto.LoginResponseDto;
import sparta.todo.dto.UserRequestDto;
import sparta.todo.dto.UserResponseDto;
import sparta.todo.service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginContorller {

    private final UserService userService;

    @PostMapping("/signup")
    public UserResponseDto signUp(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto.getUserName(), userRequestDto.getEmail(), userRequestDto.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto requestDto, HttpServletRequest request) {
        return userService.login(requestDto.getEmail(), requestDto.getPassword(), request);
    }

}
