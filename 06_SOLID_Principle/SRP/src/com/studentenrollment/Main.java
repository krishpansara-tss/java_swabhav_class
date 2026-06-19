package com.studentenrollment;

import com.studentenrollment.handler.ServiceManager;
import com.studentenrollment.model.Course;
import com.studentenrollment.model.Student;
import com.studentenrollment.reposetory.EnrollmentReposetory;
import com.studentenrollment.services.*;

public class Main {
    public static void main(String[] args) {
         StudentValidator studentValidator = new StudentValidator();
         CourseAvailabilityChecker courseAvailabilityChecker = new CourseAvailabilityChecker();
         FeeCalculator feeCalculator = new FeeCalculator();
         ConfirmationGenerator confirmationGenerator = new ConfirmationGenerator();
         EnrollmentReposetory enrollmentReposetory = new EnrollmentReposetory();
         NotificationService notificationService = new NotificationService();


        Student s1 = new Student("krish", "krish@gmail.com", 18, false);
        Course c1 = new Course("Python", "BTECH", 12, 1500, 1);

        ServiceManager serviceManager = new ServiceManager(studentValidator, courseAvailabilityChecker, feeCalculator, confirmationGenerator, enrollmentReposetory, notificationService);

        serviceManager.processEnrollment(s1, c1);

    }
}
