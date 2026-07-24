package com.tsscosultancy.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentTest {


    @Test
    void getPercentage() {
        StudentService studentService = mock(StudentService.class);

        when(studentService.getMark()).thenReturn(900.0);
        when(studentService.getSubject()).thenReturn(10);

        Student student = new Student(studentService);

        assertEquals(90.0, student.getPercentage());
    }
}