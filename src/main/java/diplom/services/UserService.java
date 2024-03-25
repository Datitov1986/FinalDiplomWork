package diplom.services;

import diplom.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUserById(Long userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long userId);
}
