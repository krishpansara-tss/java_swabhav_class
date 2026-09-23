package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.EmployeeRequestDTO;
import com.tssconsultancy.core.dto.EmployeeResponseDTO;
import com.tssconsultancy.core.models.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper
{
    Employee toEmployee(EmployeeRequestDTO requestDTO);
    EmployeeResponseDTO toResponse(Employee employee);
}
