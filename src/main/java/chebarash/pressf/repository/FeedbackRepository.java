package chebarash.pressf.repository;

import chebarash.pressf.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    @Query("{ 'professor.id': ?0 }")
    List<Feedback> findAllByProfessor(String professor);
}