package chebarash.pressf.service;

import chebarash.pressf.model.User;
import chebarash.pressf.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User create(User user) {
        return repository.save(user);
    }
}
