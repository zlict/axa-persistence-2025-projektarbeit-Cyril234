package ch.axa.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.axa.cms.models.EmployeeCourse;
import ch.axa.cms.repositories.EmployeeCourseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employeecourses")
@Tag(name = "EmployeeCourse", description = "Manage employee courses")
public class APIEmployeeCourseController {

  @Autowired
  private EmployeeCourseRepository entryRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EmployeeCourse create(@RequestBody @Valid EmployeeCourse entry) {
    return entryRepository.save(entry);
  }

  @GetMapping
  public Iterable<EmployeeCourse> index() {
    return entryRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeCourse> read(@PathVariable long id) {
    return ResponseEntity.of(entryRepository.findById(id));
  }

  @PutMapping("/{id}")
  public EmployeeCourse update(@PathVariable long id, @RequestBody @Valid EmployeeCourse entry) {
    entry.setId(id);
    return entryRepository.save(entry);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<EmployeeCourse> delete(@PathVariable long id) {
    var entry = entryRepository.findById(id);
    if(entry.isPresent()) {
      entryRepository.delete(entry.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
} 