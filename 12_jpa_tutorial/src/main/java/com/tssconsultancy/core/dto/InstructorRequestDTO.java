package com.tssconsultancy.core.dto;

import com.tssconsultancy.core.models.Course;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class InstructorRequestDTO {
    private String instructorName;
    private Double salary;
    private String designation;
}
