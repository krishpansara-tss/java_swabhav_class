package com.studentenrollment.services;

import com.studentenrollment.model.Student;

public class StudentValidator {
    public void validate(Student student){
        if(student.getStudentName() == null || student.getStudentName().isEmpty()){
            throw new IllegalArgumentException("Student name can't be null");
        }

        if(student.getStudentEmail() == null || student.getStudentEmail().isEmpty()){
            throw new IllegalArgumentException("Student email can't be null");
        }

        if(student.getAge() < 16){
            throw new IllegalArgumentException("Student age must be greater than 16");
        }
    }
}
