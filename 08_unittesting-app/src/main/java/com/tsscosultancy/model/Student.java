package com.tsscosultancy.model;

public class Student {
    StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    public double getPercentage(){
        return studentService.getMark() / studentService.getSubject();
    }

}
