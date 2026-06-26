package com.tssconsultancy.creational.prototype.solution.test;


import com.tssconsultancy.creational.prototype.solution.model.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Krish", "Java");

        Student s2 = (Student) s1.clone();
        Student s3 = (Student) s1.clone();

        s2.setName("Rushi");

        s1.show();
        s2.show();
        s3.show(); // Krish - Java
    }
}