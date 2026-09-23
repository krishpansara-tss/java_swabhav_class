package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void getCountByInstructorId_TEST() {
        Instructor instructor1 = new Instructor();
        instructor1.setInstructorName("Aman");
        instructor1.setSalary(500D);
        instructor1.setDesignation("something");
        instructorRepository.save(instructor1);

        Instructor instructor2 = new Instructor();
        instructor1.setInstructorName("Gaman");
        instructor1.setSalary(400D);
        instructor1.setDesignation("something something");
        instructorRepository.save(instructor2);

        Course course1 = new Course();
        course1.setInstructor(instructor1);
        course1.setCourseName("python");
        course1.setFees(500D);
        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setInstructor(instructor2);
        course2.setCourseName("python");
        course2.setFees(500D);
        courseRepository.save(course2);

        assertEquals(1, instructorRepository.getCountByInstructorId(instructor1.getInstructorId()));
    }

    @Test
    void getCountByInstructorId_TEST2() {
        Instructor instructor1 = new Instructor();
        instructor1.setInstructorName("Aman");
        instructor1.setSalary(500D);
        instructor1.setDesignation("something");
        instructorRepository.save(instructor1);

        Instructor instructor2 = new Instructor();
        instructor1.setInstructorName("Gaman");
        instructor1.setSalary(400D);
        instructor1.setDesignation("something something");
        instructorRepository.save(instructor2);

        Course course1 = new Course();
        course1.setInstructor(instructor1);
        course1.setCourseName("python");
        course1.setFees(500D);
        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setInstructor(instructor1);
        course2.setCourseName("python");
        course2.setFees(500D);
        courseRepository.save(course2);

        assertEquals(2, instructorRepository.getCountByInstructorId(instructor1.getInstructorId()));
    }
}