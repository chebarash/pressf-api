package chebarash.pressf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Document(collection = "feedbacks")
public class Feedback {
    private static final String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Fiona", "George", "Hannah"};
    private static final String[] lastNames = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis"};
    private static final Random random = new Random();

    @Id
    private String id;
    private int rate;
    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String professor;
    @DBRef
    private String author;

    @DBRef
    @Field("courses")
    @JsonIgnore
    private List<String> coursesIds;

    @Transient
    private List<Course> courses;

    private static String getRandomElement(String[] arr) {
        return arr[random.nextInt(arr.length)];
    }

    public static String generateRandomName() {
        return getRandomElement(firstNames) + " " + getRandomElement(lastNames);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getAuthor() {
        return generateRandomName();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getCoursesIds() {
        return coursesIds;
    }

    public void setCoursesIds(List<String> courses) {
        this.coursesIds = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}