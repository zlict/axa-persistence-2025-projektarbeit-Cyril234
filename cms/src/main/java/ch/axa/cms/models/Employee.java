package ch.axa.cms.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    private String name;
    private String mail;

    @ManyToMany
    @JoinTable(name = "employee_warning", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "warning_id"))
    @JsonIgnoreProperties(value = "employees")
    private Set<Warning> warnings = new HashSet<>();

    @ManyToMany(mappedBy = "employees")
    private Set<Course> courses = new HashSet<>();

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
    @JsonIgnoreProperties("superior")
    private Set<Employee> subordinates = new HashSet<>();

    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
} 