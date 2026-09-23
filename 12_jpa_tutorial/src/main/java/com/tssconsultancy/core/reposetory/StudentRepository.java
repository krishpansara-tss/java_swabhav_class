package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByAge(Integer age);

    Integer deleteByAge(Integer age);
}
