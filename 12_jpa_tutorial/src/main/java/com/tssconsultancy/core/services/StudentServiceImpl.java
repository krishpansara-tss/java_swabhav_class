package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.exception.StudentNotFoundException;
import com.tssconsultancy.core.mapper.StudentMapper;
import com.tssconsultancy.core.models.Address;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.reposetory.CourseRepository;
import com.tssconsultancy.core.reposetory.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    @Override
    public Page<Student> getAllStudent(int pageNumber, int size) {

        Pageable pageable = PageRequest.of(pageNumber, size);

        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with id " + id + " doesn't exist")
                );
    }

    @Override
    public Student addNewStudent(StudentRequestDTO studentRequestDTO) {
        Student student = studentMapper.toStudent(studentRequestDTO);
        Address address = new Address();
        address.setCity(studentRequestDTO.getCity());
        address.setState(studentRequestDTO.getState());
        address.setPincode(studentRequestDTO.getPincode());

        student.setAddress(address);

        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Integer deleteByAge(Integer age) {
        return studentRepository.deleteByAge(age);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setAddress(new Address());
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());

        Address address = student.getAddress();
        address.setCity(studentRequestDTO.getCity());
        address.setState(studentRequestDTO.getState());
        address.setPincode(studentRequestDTO.getPincode());

        student.setAddress(address);
        System.out.println("After setting : " + student);

        Student updated = studentRepository.save(student);

        System.out.println("updated : " + student);


        return studentMapper.toResponse(updated);
    }

    @Override
    public void enrollCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + courseId));

        student.getEnrolledCourse().add(course);

        studentRepository.save(student);
    }

    @Override
    public List<Course> getEnrolledCourseByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        return student.getEnrolledCourse();
    }

    @Override
    public void enrollMultipleCourses(Long studentId, List<Long> courseIds) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        List<Course> courseList = courseRepository.findAllById(courseIds);

        student.getEnrolledCourse().addAll(courseList);

        studentRepository.save(student);
    }

    @Override
    public Student deleteStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

//        student.isActive()

        return null;
    }
}
