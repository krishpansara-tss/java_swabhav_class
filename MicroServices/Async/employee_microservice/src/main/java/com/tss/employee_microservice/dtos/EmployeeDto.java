package com.tss.employee_microservice.dtos;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDto
{
    private Long employeeId;
    private String employeeName;
    private Long departmentId;
}
