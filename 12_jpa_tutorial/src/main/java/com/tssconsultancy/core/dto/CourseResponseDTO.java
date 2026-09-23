package com.tssconsultancy.core.dto;

import com.tssconsultancy.core.models.Instructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CourseResponseDTO {
    private Long courseId;
    private String courseName;
    private Double fees;
    private Instructor instructor;
}
