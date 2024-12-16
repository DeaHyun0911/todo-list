package sparta.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.todo.dto.UserResponseDto;
import sparta.todo.entity.Todo;
import sparta.todo.entity.User;
import sparta.todo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto save(String userName, String email) {
        User user = userRepository.save(new User(userName, email));

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
}
