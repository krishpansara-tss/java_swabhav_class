package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.dto.InstructorCourseCountDTO;
import com.tssconsultancy.core.dto.InstructorRequestDTO;
import com.tssconsultancy.core.dto.InstructorResponseDTO;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import com.tssconsultancy.core.services.InstructorServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class InstructorController {
    private final InstructorServicesImpl instructorServices;

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> addNewInstructor(@RequestBody InstructorRequestDTO instructorRequestDTO){
        System.out.println("req"  + instructorRequestDTO);
        Instructor instructor = instructorServices.addNewInstructor(instructorRequestDTO);

        return new ResponseEntity<>(instructor, HttpStatus.CREATED);
    }

    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> getAllInstructor(){
        List<Instructor> instructorList = instructorServices.getAllInstructor();
        return new ResponseEntity<>(instructorList, HttpStatus.OK);
    }

    @GetMapping("/instructor/{instructor_id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long instructor_id){
        Instructor instructorList = instructorServices.findInstructorById(instructor_id);
        return new ResponseEntity<>(instructorList, HttpStatus.OK);
    }

//    @GetMapping("/instructor/{instructor_id}")
//    public ResponseEntity<InstructorResponseDTO> getAllInstructor(@PathVariable Long instructor_id){
//        InstructorResponseDTO instructorList = instructorServices.findInstructorById(instructor_id);
//        return new ResponseEntity<>(instructorList, HttpStatus.CREATED);
//    }

    @PutMapping("/instructor/{instructor_id}/course/{course_id}")
    public ResponseEntity<Void> assignInstructorToCourse(@PathVariable Long instructor_id, @PathVariable Long course_id){
        instructorServices.assignCourseToInstructor(course_id, instructor_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/instructor/{instructor_id}/course-count")
    public ResponseEntity<Integer> getCourseCountByInstructor(@PathVariable Long instructor_id){
        Integer count = instructorServices.getCountOfCourseByInstructor(instructor_id);
        return new ResponseEntity<>(count, HttpStatus.CREATED);
    }

    @GetMapping("/instructor/all/course-count")
    public ResponseEntity<List<InstructorCourseCountDTO>> getCourseInstructorCount(){
        List<InstructorCourseCountDTO> count = instructorServices.getAllInstructorCourseCount();
        return new ResponseEntity<>(count, HttpStatus.CREATED);
    }

    @GetMapping("/instructor/{instructor_id}/course")
    public ResponseEntity<List<Course>> readCourseOfInstructor(@PathVariable Long instructor_id){
        List<Course> courseList = instructorServices.getCourseOfInstructor(instructor_id);

        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }
}
