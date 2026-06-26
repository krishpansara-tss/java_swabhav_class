package com.tssconsultancy.creational.prototype.violation.model;

public class Student {
    String name;
    String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public void show() {
        System.out.println(name + " - " + course);
    }
}
