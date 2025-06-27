package ch.axa.cms.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "departement")
public class Departement {
    
    public Departement(String name) {
        this.name = name;
    }

    public Departement() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departement_id")
    private Long id;

    @NotBlank(message = "Darf nicht leer sein!")
    private String name;

    @ManyToMany(mappedBy = "departements")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "employees")
    @JsonBackReference("departement-employees")
    private Set<Employee> employees = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
} 