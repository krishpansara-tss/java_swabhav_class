package com.tssconsultancy.core.dto;

import com.tssconsultancy.core.models.Instructor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CourseRequestDTO {
    private String courseName;
    private Double fees;
    private Instructor instructor;
}
