package chebarash.pressf.controller;


import chebarash.pressf.model.Feedback;
import chebarash.pressf.service.FeedbackService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return service.create(feedback);
    }
}