package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.dto.CourseRequestDTO;
import com.tssconsultancy.core.dto.CourseResponseDTO;
import com.tssconsultancy.core.dto.MultStudentDTO;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.services.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService;

    @PostMapping("/course")
    public ResponseEntity<CourseResponseDTO> addNewCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO course = courseService.addNewCourse(courseRequestDTO);

        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getAllCourse(){

        return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.FOUND);
    }

//    @GetMapping("/course/{course_id}")
//    public ResponseEntity<CourseResponseDTO> addNewCourse(@PathVariable Long course_id) {
//        CourseResponseDTO course = courseService.findCourseById(course_id);
//
//        return new ResponseEntity<>(course, HttpStatus.FOUND);
//    }

    @GetMapping("/course/{course_id}")
    public ResponseEntity<Course> addNewCourse(@PathVariable Long course_id) {
        Course course = courseService.findCourseById(course_id);
        System.out.println(course);
        return new ResponseEntity<>(course, HttpStatus.FOUND);
    }


    @PutMapping("/course/{course_id}/instructor/{instructor_id}")
    public ResponseEntity<Void> assignInstructorToCourse(@PathVariable Long course_id, @PathVariable Long instructor_id){
        courseService.assignInstructorToCourse(course_id, instructor_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/course/{course_id}/instructor")
    public ResponseEntity<String> readInstructorOfCourse(@PathVariable Long course_id){
        Instructor instructor = courseService.getInstructorOfCourse(course_id);
        return new ResponseEntity<>(instructor.getInstructorName(), HttpStatus.OK);
    }


    @PostMapping("/course/{course_id}/students/{student_id}/")
    public ResponseEntity<Void> assignCourse( @PathVariable Long course_id, @PathVariable Long student_id){
        courseService.assignCourse(course_id, student_id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/course/{course_id}/students")
    public ResponseEntity<List<Student>> getEnrolledCourse(@PathVariable Long course_id){
        List<Student> enrolledCourse = courseService.getStudentsByCourseId(course_id);
        System.out.println("contolr" + enrolledCourse);
        return new ResponseEntity<>(enrolledCourse, HttpStatus.FOUND);
    }

    @PostMapping("/course/{course_id}/students")
    public ResponseEntity<Void> assignMultipleStudentToCourse(@PathVariable Long course_id, @RequestBody MultStudentDTO request){
        System.out.println("hii");
        System.out.println(request);
        courseService.assignMultipleStudentToCourse(course_id, request.getStudentIdList());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
