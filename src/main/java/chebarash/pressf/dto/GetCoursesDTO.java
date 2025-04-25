package chebarash.pressf.dto;

import chebarash.pressf.model.Course;

import java.util.List;

public class GetCoursesDTO {
    List<Course> courses;

    public GetCoursesDTO(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
