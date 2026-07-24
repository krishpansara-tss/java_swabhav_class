package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.mapper.StudentMapper;
import com.tssconsultancy.core.models.Student;
import com.tssconsultancy.core.services.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;
    private final StudentMapper studentMapper;

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudent(){
        List<Student> studentsList = studentServiceImpl.getAllStudent();
        List<StudentResponseDTO> studentResponseList = new ArrayList<>();

        for(Student s : studentsList){
            StudentResponseDTO studentResponseDTO = studentMapper.toResponse(s);
            studentResponseList.add(studentResponseDTO);
        }

        return new ResponseEntity<>(studentResponseList, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id){
        Student student = studentServiceImpl.getStudentById(id);
        StudentResponseDTO studentResponseDTO = studentMapper.toResponse(student);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/students/")
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        Student student = studentMapper.toStudent(studentRequestDTO);

        studentServiceImpl.addNewStudent(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    private Student studentRequestDtoToStudent(StudentRequestDTO studentRequestDTO){
//        Student student = new Student();
//        student.setName(studentRequestDTO.getName());
//        student.setAge(studentRequestDTO.getAge());
//
//        return  student;
//    }
//
//    private StudentResponseDTO studentToStudentResponseDto(Student student){
//        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
//        studentResponseDTO.setId(student.getId());
//        studentResponseDTO.setName(student.getName());
//
//        return  studentResponseDTO;
//    }
}