package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.dto.CourseIdListDTO;
import com.tssconsultancy.core.dto.PageResponseDTO;
import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.mapper.PageMapper;
import com.tssconsultancy.core.mapper.StudentMapper;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.services.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;
    private final StudentMapper studentMapper;
    private final PageMapper<Student> pageMapper;
//    private final Temp<Student> studentTemp;


//    @GetMapping("/students")
//    public ResponseEntity<PageResponseDTO> getAllStudent(@RequestParam int pageNumber, @RequestParam int size){
//
//        Page<Student> studentsList = studentServiceImpl.getAllStudent(pageNumber, size);
//        PageResponseDTO pageResponseDTO1 = studentTemp.toPageResponse(studentsList);
//
//        return new ResponseEntity<>(pageResponseDTO1, HttpStatus.OK);
//    }


    @GetMapping("/students")
    public ResponseEntity<PageResponseDTO> getAllStudent(@RequestParam int pageNumber, @RequestParam int size){

        Page<Student> studentsList = studentServiceImpl.getAllStudent(pageNumber, size);
        PageResponseDTO pageResponseDTO1 = pageMapper.toPageResponse(studentsList);

        return new ResponseEntity<>(pageResponseDTO1, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id){
        Student student = studentServiceImpl.getStudentById(id);
        StudentResponseDTO studentResponseDTO = studentMapper.toResponse(student);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/students/")
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO){
        Student student = studentServiceImpl.addNewStudent(studentRequestDTO);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id,
                                                            @Valid @RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO student = studentServiceImpl.updateStudent(id, studentRequestDTO);
        System.out.println(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{age}")
    public ResponseEntity<String> deleteByAge(@PathVariable Integer age){
        Integer deletedCount = studentServiceImpl.deleteByAge(age);

        if(deletedCount == 0){
            return ResponseEntity.
                    status(HttpStatus.NOT_FOUND)
                    .body("No students found with age: " + age);
        }
        return ResponseEntity.ok(deletedCount + " student deleted successfully");
    }

    @PostMapping("/students/{student_id}/course/{course_id}")
    public ResponseEntity<Void> enrollCourse(@PathVariable Long student_id, @PathVariable Long course_id){
        studentServiceImpl.enrollCourse(student_id, course_id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/students/{student_id}/course")
    public ResponseEntity<List<Course>> getEnrolledCourse(@PathVariable Long student_id){
        List<Course> enrolledCourse = studentServiceImpl.getEnrolledCourseByStudentId(student_id);
        System.out.println("contolr" + enrolledCourse);
        return new ResponseEntity<>(enrolledCourse, HttpStatus.FOUND);
    }

    @PostMapping("/students/{student_id}/course")
    public ResponseEntity<Void> enrollMultipleCourse(@PathVariable Long student_id, @RequestBody CourseIdListDTO request){
        studentServiceImpl.enrollMultipleCourses(student_id, request.getCourseIds());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/students/{student_id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long student_id){
        Student student = studentServiceImpl.deleteStudentById(student_id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}