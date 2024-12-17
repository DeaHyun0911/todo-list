package sparta.todo.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.SessionConst;
import sparta.todo.dto.LoginResponseDto;
import sparta.todo.dto.UserResponseDto;
import sparta.todo.entity.Todo;
import sparta.todo.entity.User;
import sparta.todo.exception.ExistsEmailException;
import sparta.todo.exception.PasswordMismatchException;
import sparta.todo.repository.UserRepository;

import java.net.PasswordAuthentication;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto save(String userName, String email, String password) {
        if(userRepository.existsByEmail(email)) {
            throw new ExistsEmailException();
        }

        User user = userRepository.save(new User(userName, email, password));

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

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public LoginResponseDto login(String email, String password, HttpServletRequest request) {
        System.out.println(userRepository.findByEmail(email));
        User user = userRepository.findByEmailOrElseThrow(email);

        if (!user.getPassword().equals(password)) {
            throw new PasswordMismatchException();
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);

        return new LoginResponseDto(user.getEmail(), session.getId());
    }
}
