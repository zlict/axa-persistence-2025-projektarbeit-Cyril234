package ch.axa.cms.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee_course")
public class EmployeeCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_course_id")
    private long id;

    @NotNull
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean finished;

    private int duration;

    private int score;

    @ManyToOne
    @JsonIgnoreProperties(value = "employee_course")
    private Course course;

    @ManyToOne
    @JsonIgnoreProperties(value = "employee_course")
    private Employee employee;

    public EmployeeCourse() {
    }

    public EmployeeCourse(boolean finished, int duration, int score, Course course, Employee employee) {
        this.finished = finished;
        this.duration = duration;
        this.score = score;
        this.course = course;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
