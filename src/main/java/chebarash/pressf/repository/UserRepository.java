package chebarash.pressf.repository;

import chebarash.pressf.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}