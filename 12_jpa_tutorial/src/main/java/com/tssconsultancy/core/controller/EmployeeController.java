package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.dto.EmployeeRequestDTO;
import com.tssconsultancy.core.dto.EmployeeResponseDTO;
import com.tssconsultancy.core.error.EmployeeError;
import com.tssconsultancy.core.error.StudentError;
import com.tssconsultancy.core.exception.EmployeeNotFoundException;
import com.tssconsultancy.core.exception.StudentNotFoundException;
import com.tssconsultancy.core.mapper.EmployeeMapper;
import com.tssconsultancy.core.models.Employee;
import com.tssconsultancy.core.services.EmployeeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        List<EmployeeResponseDTO> employeeResponseList = new ArrayList<>();

        for(Employee e : employeeList){
            EmployeeResponseDTO employeeResponseDTO = employeeMapper.toResponse(e);
            employeeResponseList.add(employeeResponseDTO);
        }

        return new ResponseEntity<>( employeeResponseList, HttpStatus.FOUND);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeResponseDTO employeeResponseDTO = employeeMapper.toResponse(employee);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.FOUND);
    }


    @PostMapping("/employee")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        Employee employee = employeeMapper.toEmployee(employeeRequestDTO);

        employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    private ResponseEntity<EmployeeError> studentNotFoundExceptionHandler(EmployeeNotFoundException studentNotFoundException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>(new EmployeeError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), studentNotFoundException.getMessage(),  httpServletRequest.getRequestURI()), HttpStatus.NOT_FOUND);
    }


//    private Employee employeeResponseDtoToEmployee(EmployeeRequestDTO employeeRequestDTO){
//        Employee employee = new Employee();
//        employee.setName(employeeRequestDTO.getName());
//        employee.setSalary(employeeRequestDTO.getSalary());
//
//        return employee;
//    }
//
//    private EmployeeResponseDTO employeeToEmployeeResponseDTO(Employee employee){
//        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
//        employeeResponseDTO.setId(employee.getId());
//        employeeResponseDTO.setName(employee.getName());
//
//        return  employeeResponseDTO;
//    }
}

