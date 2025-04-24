package chebarash.pressf.controller;

import chebarash.pressf.model.Course;
import chebarash.pressf.model.Feedback;
import chebarash.pressf.model.Professor;
import chebarash.pressf.service.CourseService;
import chebarash.pressf.service.FeedbackService;
import chebarash.pressf.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private CourseService courseService;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> all() {
        List<Professor> professors = service.getAll();
        List<Course> courses = courseService.getAll();
        Map<String, Object> result = new HashMap<>();
        result.put("professors", professors);
        result.put("courses", courses);
        return result;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable String id) {
        Professor professor = service.getById(id);
        List<Feedback> feedbacks = feedbackService.getAllByProfessor(id);
        Map<String, Object> result = new HashMap<>();
        result.put("professor", professor);
        result.put("feedbacks", feedbacks);
        return result;
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }
}