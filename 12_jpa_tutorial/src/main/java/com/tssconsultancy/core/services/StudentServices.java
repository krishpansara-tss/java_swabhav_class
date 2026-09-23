package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Student;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
    public Page<Student> getAllStudent(int pageNumber, int size);

    public Student getStudentById(Long id);

    public Student addNewStudent(StudentRequestDTO studentRequestDTO);

    Integer deleteByAge(Integer age);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO);

    void enrollCourse(Long studentId, Long courseId);

    List<Course> getEnrolledCourseByStudentId(Long studentId);

    void enrollMultipleCourses(Long studentId, List<Long> courseIds);

    Student deleteStudentById(Long studentId);
}
