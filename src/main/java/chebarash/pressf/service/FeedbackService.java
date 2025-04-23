package chebarash.pressf.service;

import chebarash.pressf.model.Feedback;
import chebarash.pressf.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> getAll() {
        return repository.findAll();
    }

    public Feedback create(Feedback feedback) {
        return repository.save(feedback);
    }
}