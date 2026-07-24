package com.tssconsultancy.core.services;

import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.reposetory.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student with id " + id + " doesn't exist")
                );
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }
}
