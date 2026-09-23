package com.tssconsultancy.core.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class InstructorResponseDTO {
    private Long instructorId;
    private String instructorName;
    private String designation;
}
