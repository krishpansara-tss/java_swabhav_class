package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.PageResponseDTO;
import com.tssconsultancy.core.dto.StudentRequestDTO;
import com.tssconsultancy.core.dto.StudentResponseDTO;
import com.tssconsultancy.core.models.Student;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    public Student toStudent(StudentRequestDTO studentRequestDTO);
    public StudentResponseDTO toResponse(Student student);
}
