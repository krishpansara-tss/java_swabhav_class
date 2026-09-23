package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.InstructorCourseCountDTO;
import com.tssconsultancy.core.dto.InstructorRequestDTO;
import com.tssconsultancy.core.dto.InstructorResponseDTO;
import com.tssconsultancy.core.models.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    public Instructor toEntity(InstructorRequestDTO instructorRequestDTO);
    public InstructorResponseDTO toResponse(Instructor instructor);
    InstructorCourseCountDTO toCountResponse(String name, Long size);

}
