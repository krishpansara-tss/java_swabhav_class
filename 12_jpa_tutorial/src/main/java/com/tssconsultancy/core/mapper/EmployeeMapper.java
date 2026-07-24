package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.EmployeeRequestDTO;
import com.tssconsultancy.core.dto.EmployeeResponseDTO;
import com.tssconsultancy.core.models.Employee;

public interface EmployeeMapper
{
    Employee toEmployee(EmployeeRequestDTO requestDTO);
    EmployeeResponseDTO toResponse(Employee employee);
}
