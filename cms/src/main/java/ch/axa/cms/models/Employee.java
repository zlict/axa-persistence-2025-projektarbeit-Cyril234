package ch.axa.cms.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @NotBlank(message = "Darf nicht leer sein!")
    private String name;

    @NotBlank(message = "Darf nicht leer sein!")
    private String mail;

    @ManyToMany
    @JoinTable(name = "employee_warning", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "warning_id"))
    @JsonIgnoreProperties(value = "employees")
    private Set<Warning> warnings = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonBackReference("employee-employeeCourses")
    private Set<EmployeeCourse> employeeCourses = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "employees")
    private Departement departement;

    // Selbstbeziehung: Vorgesetzter
    @ManyToOne
    @JoinColumn(name = "superior_id")
    @JsonIgnoreProperties("subordinates")
    private Employee superior;

    // Selbstbeziehung: Untergebene
    @OneToMany(mappedBy = "superior")
    @JsonBackReference("superior-subordinates")
    private Set<Employee> subordinates = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, String mail, Departement departement, Employee superior) {
        this.name = name;
        this.mail = mail;
        this.departement = departement;
        this.superior = superior;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Employee getSuperior() {
        return superior;
    }

    public void setSuperior(Employee superior) {
        this.superior = superior;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }


    
} 