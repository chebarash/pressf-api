package chebarash.pressf.repository;

import chebarash.pressf.model.Feedback;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findAllByProfessor(ObjectId professor);
}