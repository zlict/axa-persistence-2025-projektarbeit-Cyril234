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

import ch.axa.cms.models.Warning;
import ch.axa.cms.repositories.WarningRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/warnings")
@Tag(name = "Warning", description = "Manage warnings")
public class APIWarningController {

  @Autowired
  private WarningRepository entryRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Warning create(@RequestBody @Valid Warning entry) {
    return entryRepository.save(entry);
  }

  @GetMapping
  public Iterable<Warning> index() {
    return entryRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Warning> read(@PathVariable long id) {
    return ResponseEntity.of(entryRepository.findById(id));
  }

  @PutMapping("/{id}")
  public Warning update(@PathVariable long id, @RequestBody @Valid Warning entry) {
    entry.setId(id);
    return entryRepository.save(entry);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Warning> delete(@PathVariable long id) {
    var entry = entryRepository.findById(id);
    if(entry.isPresent()) {
      entryRepository.delete(entry.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
} 