package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
