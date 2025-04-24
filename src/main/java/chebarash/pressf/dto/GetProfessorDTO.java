package chebarash.pressf.dto;

import chebarash.pressf.model.Feedback;
import chebarash.pressf.model.Professor;

import java.util.List;

public class GetProfessorDTO {
    Professor professors;
    List<Feedback> feedbacks;

    public GetProfessorDTO(Professor professors, List<Feedback> feedbacks) {
        this.professors = professors;
        this.feedbacks = feedbacks;
    }

    public Professor getProfessors() {
        return professors;
    }

    public void setProfessors(Professor professors) {
        this.professors = professors;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
