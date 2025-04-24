package chebarash.pressf.service;

import chebarash.pressf.model.Course;
import chebarash.pressf.model.Professor;
import chebarash.pressf.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private FeedbackService feedbackService;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> getAll() {
        List<Professor> professors = repository.findAll();
        for (Professor professor : professors) {
            List<Course> courses = courseService.getAllById(professor.getCoursesIds());
            professor.setCourses(courses);
        }
        return professors;
    }

    public Professor getById(String id) {
        Professor professor = repository.findById(id).orElse(null);
        if (professor == null) return null;
        List<Course> courses = courseService.getAllById(professor.getCoursesIds());
        professor.setCourses(courses);
        return professor;
    }

    public Professor create(Professor professor) {
        return repository.save(professor);
    }
}