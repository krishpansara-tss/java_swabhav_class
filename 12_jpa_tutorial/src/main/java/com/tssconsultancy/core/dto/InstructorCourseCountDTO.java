package com.tssconsultancy.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class InstructorCourseCountDTO {
    private String instructorName;
    private Long courseCount;
}
