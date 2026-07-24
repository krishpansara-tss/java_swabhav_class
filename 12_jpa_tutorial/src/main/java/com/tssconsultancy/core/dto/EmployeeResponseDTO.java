package com.tssconsultancy.core.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeResponseDTO {
    private Long id;
    private String name;
}
