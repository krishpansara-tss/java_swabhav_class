package com.tss.employee_microservice.dtos;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
}
