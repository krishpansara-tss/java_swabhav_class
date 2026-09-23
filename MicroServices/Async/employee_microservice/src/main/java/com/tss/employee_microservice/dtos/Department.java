package com.tss.employee_microservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Department {
    private Long departmentId;
    private String departmentName;
}
