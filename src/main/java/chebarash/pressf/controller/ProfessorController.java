package chebarash.pressf.controller;

import chebarash.pressf.dto.GetProfessorDTO;
import chebarash.pressf.dto.GetProfessorsDTO;
import chebarash.pressf.model.Course;
import chebarash.pressf.model.Feedback;
import chebarash.pressf.model.Professor;
import chebarash.pressf.service.CourseService;
import chebarash.pressf.service.FeedbackService;
import chebarash.pressf.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public GetProfessorsDTO all() {
        List<Professor> professors = service.getAll();
        List<Course> courses = courseService.getAll();
        return new GetProfessorsDTO(professors, courses);
    }

    @GetMapping("/{id}")
    public GetProfessorDTO getById(@PathVariable String id) {
        Professor professor = service.getById(id);
        List<Feedback> feedbacks = feedbackService.getAllByProfessor(id);
        return new GetProfessorDTO(professor, feedbacks);
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }
}