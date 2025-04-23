package chebarash.pressf.repository;

import chebarash.pressf.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {}