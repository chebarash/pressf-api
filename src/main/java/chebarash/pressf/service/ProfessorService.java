package chebarash.pressf.service;

import chebarash.pressf.model.Course;
import chebarash.pressf.model.Feedback;
import chebarash.pressf.model.Professor;
import chebarash.pressf.repository.CourseRepository;
import chebarash.pressf.repository.FeedbackRepository;
import chebarash.pressf.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> getAll() {
        List<Professor> professors = repository.findAll();
        for (Professor professor : professors) {
            List<Course> courses = courseRepository.findAllById(professor.getCoursesIds());
            professor.setCourses(courses);
        }
        return professors;
    }

    public Professor getById(String id) {
        Professor professor = repository.findById(id).orElse(null);
        if (professor == null) return null;
        List<Course> courses = courseRepository.findAllById(professor.getCoursesIds());
        List<Feedback> feedbacks = feedbackRepository.findAllByProfessor(id);
        System.out.println(feedbacks);
        professor.setCourses(courses);
        return professor;
    }

    public Professor create(Professor professor) {
        return repository.save(professor);
    }
}