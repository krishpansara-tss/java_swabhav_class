package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    public Student toStudent(StudentRequestDTO studentRequestDTO);
    public StudentResponseDTO toResponse(Student student);
}
