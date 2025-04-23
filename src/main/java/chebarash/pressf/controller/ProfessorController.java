package chebarash.pressf.controller;

import chebarash.pressf.model.Professor;
import chebarash.pressf.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }
}