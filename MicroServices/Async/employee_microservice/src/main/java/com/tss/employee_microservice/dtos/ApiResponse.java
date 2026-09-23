package com.tss.employee_microservice.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class ApiResponse {
    private Department department;
    private EmployeeDto employeeDto;
}
