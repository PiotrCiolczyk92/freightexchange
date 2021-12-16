package pl.piocom.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.getById(id);
    }

    public void create(User user) {
        if (user.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Created user can't have existing id");
            log.error("User has not been created", exception);
        }
        userRepository.save(user);
    }

}
