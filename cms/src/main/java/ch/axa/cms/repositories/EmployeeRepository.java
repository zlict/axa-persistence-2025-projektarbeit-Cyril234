package ch.axa.cms.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.axa.cms.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {} 