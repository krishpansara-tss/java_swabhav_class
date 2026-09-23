package com.tssconsultancy.core.services;

import com.tssconsultancy.core.reposetory.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServicesImplTest {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorServicesImpl instructorServices;

    @Test
    void canDeleteInstructor() {
        when(instructorRepository.getCountByInstructorId(1L)).thenReturn(2);
//        boolean result =

        assertTrue(instructorServices.canDeleteInstructor(1L));
    }

    @Test
    void canDeleteInstructor_DELETABLE() {
        when(instructorRepository.getCountByInstructorId(1L)).thenReturn(1);

        assertFalse(instructorServices.canDeleteInstructor(1L));
    }

    @Test
    void shouldReturnTrue_whenInstructorHasMoreThanOneCourse() {
        // given
        when(instructorRepository.getCountByInstructorId(1L)).thenReturn(2);

        // when
        boolean result = instructorServices.canDeleteInstructor(1L);

        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse_whenInstructorHasOneOrZeroCourses() {
        // given
        when(instructorRepository.getCountByInstructorId(1L)).thenReturn(1);

        // when
        boolean result = instructorServices.canDeleteInstructor(1L);

        // then
        assertFalse(result);
    }
}