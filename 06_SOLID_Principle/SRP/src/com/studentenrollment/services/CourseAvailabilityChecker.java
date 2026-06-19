package com.studentenrollment.services;

import com.studentenrollment.model.Course;

public class CourseAvailabilityChecker {
    public void checkAvailability(Course course){
        if(course == null || course.getCourseName() == null || course.getCourseName().isEmpty()){
            throw  new IllegalArgumentException("Selected course doesn't exist");
        }

        if(course.getAvailableSeats() <= 0){
            throw  new IllegalArgumentException("No seats available for the selected course");
        }
    }
}
