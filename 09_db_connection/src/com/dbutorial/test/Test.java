package com.dbutorial.test;

import com.dbutorial.database.DBConnection;
import com.dbutorial.model.Course;
import com.dbutorial.model.Student;
import com.dbutorial.services.CourseServices;
import com.dbutorial.services.StudentServices;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentServices studentServices = new StudentServices();
        CourseServices courseService = new CourseServices();

//        courseService.addCourse(new Course("Python", "Snehal", 500, 10));
//        courseService.addCourse(new Course("Flutter", "Aarzoo", 1599, 15));
        List<Course> courseList = courseService.getAllCourse();
        for(Course c : courseList){
            System.out.println(c.toString());
        }

        studentServices.enrollStudent(10, 1);
    }
}
