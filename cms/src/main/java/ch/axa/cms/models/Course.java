package ch.axa.cms.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;

    @NotNull(message = "Bitte gib den endzeitpukt bekannt!")
    private LocalDateTime expirationDate;

    @NotBlank(message = "Darf nicht leer sein!")
    private String description;

    @Column(nullable = false)
    private int duration;

    public Course(LocalDateTime expirationDate, String description, int duration) {
        this.expirationDate = expirationDate;
        this.description = description;
        this.duration = duration;
    }

    public Course() {

    }

    @ManyToMany
    @JoinTable(name = "cours_departement", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "departement_id"))
    @JsonIgnoreProperties(value = "courses")
    private Set<Departement> departements = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "courses")
    private Category category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "courses")
    private Set<Warning> warnings = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "courses")
    private Set<EmployeeCourse> employeeCourses = new HashSet<>();

    public Course(LocalDateTime expirationDate, String description, Category category) {
        this.expirationDate = expirationDate;
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(Set<Departement> departements) {
        this.departements = departements;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(Set<Warning> warnings) {
        this.warnings = warnings;
    }

    public Set<EmployeeCourse> getEmployeeCourses() {
        return employeeCourses;
    }

    public void setEmployeeCourses(Set<EmployeeCourse> employeeCourses) {
        this.employeeCourses = employeeCourses;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
