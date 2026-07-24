package com.tssconsultancy.core.services;

import com.tssconsultancy.core.models.Student;

import java.util.List;

public interface StudentServices {
    public List<Student> getAllStudent();

    public Student getStudentById(Long id);

    public Student addNewStudent(Student student);
}
