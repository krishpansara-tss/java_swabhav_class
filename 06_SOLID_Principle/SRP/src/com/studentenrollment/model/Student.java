package com.studentenrollment.model;

public class Student {
    private String studentName;
    private String studentEmail;
    private int age;
    private boolean hasScholarship;

    public Student(String studentName, String studentEmail, int age, boolean hasScholarship) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.age = age;
        this.hasScholarship = hasScholarship;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public int getAge() {
        return age;
    }

    public boolean hasScholarship() {
        return hasScholarship;
    }
}
