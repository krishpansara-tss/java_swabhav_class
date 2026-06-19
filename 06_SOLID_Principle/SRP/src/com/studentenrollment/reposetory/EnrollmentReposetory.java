package com.studentenrollment.reposetory;

import com.studentenrollment.model.Enrollment;

public class EnrollmentReposetory {
    public void saveEnrollment(Enrollment enrollment){
        System.out.println("Enrollment saved to database");
        enrollment.getCourse().decrementSeats();
    }
}
