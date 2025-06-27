package ch.axa.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.axa.cms.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "SELECT * from employee u WHERE u.email LIKE %:email%", nativeQuery = true)
    List<Employee> searchByEmail(@Param("email") String email);
} 