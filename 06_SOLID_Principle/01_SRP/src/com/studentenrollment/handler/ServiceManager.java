package com.studentenrollment.handler;

import com.studentenrollment.model.Course;
import com.studentenrollment.model.Enrollment;
import com.studentenrollment.model.Student;
import com.studentenrollment.reposetory.EnrollmentReposetory;
import com.studentenrollment.services.*;

public class ServiceManager {
    private StudentValidator studentValidator;
    private CourseAvailabilityChecker courseAvailabilityChecker;
    private FeeCalculator feeCalculator;
    private ConfirmationGenerator confirmationGenerator;
    private EnrollmentReposetory enrollmentReposetory;
    private NotificationService notificationService;

    public ServiceManager(StudentValidator studentValidator, CourseAvailabilityChecker courseAvailabilityChecker, FeeCalculator feeCalculator, ConfirmationGenerator confirmationGenerator, EnrollmentReposetory enrollmentReposetory, NotificationService notificationService) {
        this.studentValidator = studentValidator;
        this.courseAvailabilityChecker = courseAvailabilityChecker;
        this.feeCalculator = feeCalculator;
        this.confirmationGenerator = confirmationGenerator;
        this.enrollmentReposetory = enrollmentReposetory;
        this.notificationService = notificationService;
    }

    public void processEnrollment(Student student, Course course) {
        try {

            studentValidator.validate(student);
            courseAvailabilityChecker.checkAvailability(course);
            double fee = feeCalculator.calculateFees(course, student);


            String confirmationNuber = confirmationGenerator.generateConfirmation();
            Enrollment enrollment = new Enrollment(student, course, fee, confirmationNuber);
            enrollmentReposetory.saveEnrollment(enrollment);
            notificationService.sendNotification("Successfully done enrollment with fee: "+ fee + " and confirmation number:" + confirmationNuber);
        } catch (Exception e) {
            System.out.println("Error occur: " + e.getMessage() );
        }
    }
}