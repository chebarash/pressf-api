package chebarash.pressf.controller;

import chebarash.pressf.model.Course;
import chebarash.pressf.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> all() {
        return service.getAll();
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.create(course);
    }
}