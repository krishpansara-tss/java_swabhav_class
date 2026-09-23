package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.InstructorCourseCountDTO;
import com.tssconsultancy.core.dto.InstructorRequestDTO;
import com.tssconsultancy.core.dto.InstructorResponseDTO;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;

import java.util.List;

public interface InstructorServices {

    Instructor addNewInstructor(InstructorRequestDTO instructorRequestDTO);

    List<Instructor> getAllInstructor();

    void assignCourseToInstructor(Long courseId, Long instructorId);

//    InstructorResponseDTO findInstructorById(Long instructorId);

    boolean canDeleteInstructor(Long inst_id);
    Instructor findInstructorById(Long instructorId);

    List<Course> getCourseOfInstructor(Long instructorId);

    List<InstructorCourseCountDTO> getAllInstructorCourseCount();
}
