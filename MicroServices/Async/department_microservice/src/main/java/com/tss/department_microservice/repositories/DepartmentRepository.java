package com.tss.department_microservice.repositories;

import com.tss.department_microservice.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
