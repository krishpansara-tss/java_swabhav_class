package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.CourseRequestDTO;
import com.tssconsultancy.core.dto.CourseResponseDTO;
import com.tssconsultancy.core.models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO toResponse(Course course);

}
