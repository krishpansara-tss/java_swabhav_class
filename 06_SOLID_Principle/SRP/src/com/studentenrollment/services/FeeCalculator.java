package com.studentenrollment.services;

import com.studentenrollment.model.Course;
import com.studentenrollment.model.Student;

public class FeeCalculator {
    public double calculateFees(Course course, Student student){
        double fee = course.getBaseFee();

        if("BTECH".equals(course.getCourseType())){
            fee *= 1.5;
        }
        if(student.hasScholarship()){
            fee *= 0.5;
        }

        return fee;
    }
}
