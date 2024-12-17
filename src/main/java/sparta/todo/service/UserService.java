package sparta.todo.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.SessionConst;
import sparta.todo.config.PasswordEncoder;
import sparta.todo.dto.LoginResponseDto;
import sparta.todo.dto.UserResponseDto;
import sparta.todo.entity.User;
import sparta.todo.exception.ExistsEmailException;
import sparta.todo.exception.PasswordMismatchException;
import sparta.todo.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserResponseDto save(String userName, String email, String password) {

        if(userRepository.existsByEmail(email)) {
            throw new ExistsEmailException();
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = userRepository.save(new User(userName, email, encodedPassword));

        return new UserResponseDto(user);
    }


    public UserResponseDto findById(Long id) {

        User user = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(user);
    }


    @Transactional
    public UserResponseDto updatedUser(Long id, String userName) {

        User user = userRepository.findByIdOrElseThrow(id);
        user.updateUserName(userName);

        return new UserResponseDto(user);
    }


    public void deleteUser(Long id)
    {
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }


    public LoginResponseDto login(String email, String password, HttpServletRequest request) {

        User user = userRepository.findByEmailOrElseThrow(email);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordMismatchException();
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);

        return new LoginResponseDto(user.getEmail(), session.getId());
    }
}
