package com.tss.employee_microservice.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateDepartmentDto {
    private Long employeeId;
    private Long departmentId;
}
