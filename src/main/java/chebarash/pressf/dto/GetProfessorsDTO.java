package chebarash.pressf.dto;

import chebarash.pressf.model.Course;
import chebarash.pressf.model.Professor;

import java.util.List;

public class GetProfessorsDTO {
    List<Professor> professors;
    List<Course> courses;

    public GetProfessorsDTO(List<Professor> professors, List<Course> courses) {
        this.professors = professors;
        this.courses = courses;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
