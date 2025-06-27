package ch.axa.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.axa.cms.models.Course;
import ch.axa.cms.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "SELECT c.* FROM employee_course ec JOIN course c ON ec.course_course_id = c.course_id WHERE ec.employee_employee_id = :employeeId;", nativeQuery = true)
    List<Course> getAllCourse(@Param("employeeId") String employeeId);
} 