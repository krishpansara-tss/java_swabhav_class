package com.studentenrollment.model;

public class Enrollment {
    private Student student;
    private  Course course;
    private double finalFee;
    private String conformationNumber;

    public Enrollment(Student student, Course course, double finalFee, String conformationNumber) {
        this.student = student;
        this.course = course;
        this.finalFee = finalFee;
        this.conformationNumber = conformationNumber;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getFinalFee() {
        return finalFee;
    }

    public String getConformationNumber() {
        return conformationNumber;
    }
}
