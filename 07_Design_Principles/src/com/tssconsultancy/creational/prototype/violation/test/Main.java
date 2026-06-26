package com.tssconsultancy.creational.prototype.violation.test;

import com.tssconsultancy.creational.prototype.violation.model.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Krish", "Java");
        Student s2 = new Student("Krish", "Java");
        Student s3 = new Student("Krish", "Java");

        s1.show();
        s2.show();
        s3.show();
    }
}
