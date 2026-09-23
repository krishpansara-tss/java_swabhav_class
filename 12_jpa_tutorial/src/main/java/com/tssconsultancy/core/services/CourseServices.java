package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.CourseRequestDTO;
import com.tssconsultancy.core.dto.CourseResponseDTO;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import com.tssconsultancy.core.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseServices {
    CourseResponseDTO addNewCourse(CourseRequestDTO courseRequestDTO);
    List<Course> getAllCourse();

    void assignInstructorToCourse(Long courseId, Long instructorId);

    Course findCourseById(Long courseId);

    Instructor getInstructorOfCourse(Long courseId);

    void assignCourse(Long courseId, Long studentId);

    List<Student> getStudentsByCourseId(Long courseId);

    void assignMultipleStudentToCourse(Long courseId, List<Long> studentIdList);
//    CourseResponseDTO findCourseById(Long courseId);

}
