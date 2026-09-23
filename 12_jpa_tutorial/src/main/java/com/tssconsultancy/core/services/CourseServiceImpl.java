package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.CourseRequestDTO;
import com.tssconsultancy.core.dto.CourseResponseDTO;
import com.tssconsultancy.core.mapper.CourseMapper;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.reposetory.CourseRepository;
import com.tssconsultancy.core.reposetory.InstructorRepository;
import com.tssconsultancy.core.reposetory.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements  CourseServices {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponseDTO addNewCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();

        course.setCourseName(courseRequestDTO.getCourseName());
        course.setFees(courseRequestDTO.getFees());

        return courseMapper.toResponse(courseRepository.save(course));
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long instructorId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course Having ID:" + courseId + " doesn't exists.")
        );

        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor Having ID:" + instructorId + " doesn't exists.")
        );

        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    @Override
    public Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course having ID: " + courseId + " doesn't exist")
        );
    }

//    @Override
//    public CourseResponseDTO findCourseById(Long courseId) {
//        Course course = courseRepository.findById(courseId).orElseThrow(
//                () -> new RuntimeException("Course having ID: " + courseId + " doesn't exist")
//        );
//        System.out.println(course);
//
//        return courseMapper.toResponse(course);
//    }


    @Override
    public Instructor getInstructorOfCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course Having ID:" + courseId + " doesn't exists.")
        );

        return course.getInstructor();
    }

    @Override
    public void assignCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + courseId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        student.getEnrolledCourse().add(course);

        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + courseId));

        return  course.getEnrolledStudents();
    }

    @Override
    public void assignMultipleStudentToCourse(Long courseId, List<Long> studentIdList) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + courseId));


        List<Student> students = studentRepository.findAllById(studentIdList);

        for(Student student : students){
            student.getEnrolledCourse().add(course);
        }

        studentRepository.saveAll(students);
    }
}
