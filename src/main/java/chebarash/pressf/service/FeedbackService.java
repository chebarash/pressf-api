package chebarash.pressf.service;

import chebarash.pressf.model.Course;
import chebarash.pressf.model.Feedback;
import chebarash.pressf.repository.FeedbackRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repository;

    @Autowired
    private CourseService courseService;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> getAllByProfessor(String id) {
        ObjectId professorId = new ObjectId(id);
        List<Feedback> feedbacks = repository.findAllByProfessor(professorId);
        for (Feedback feedback : feedbacks) {
            List<Course> courses = courseService.getAllById(feedback.getCoursesIds());
            feedback.setCourses(courses);
        }
        return feedbacks;
    }

    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }
}