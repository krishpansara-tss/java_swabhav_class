package com.tssconsultancy.core.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeRequestDTO {
    private String name;
    private Double salary;
}
