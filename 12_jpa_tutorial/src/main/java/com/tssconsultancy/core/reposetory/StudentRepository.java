package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
