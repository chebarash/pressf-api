package chebarash.pressf.service;

import chebarash.pressf.model.Course;
import chebarash.pressf.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public List<Course> getAllById(List<String> ids) {
        return repository.findAllById(ids);
    }

    public Course create(Course course) {
        return repository.save(course);
    }
}