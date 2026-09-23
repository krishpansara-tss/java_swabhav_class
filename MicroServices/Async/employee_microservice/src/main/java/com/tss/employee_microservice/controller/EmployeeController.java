package com.tss.employee_microservice.controller;

import com.tss.employee_microservice.dtos.ApiResponse;
import com.tss.employee_microservice.dtos.EmployeeRequestDto;
import com.tss.employee_microservice.dtos.UpdateDepartmentDto;
import com.tss.employee_microservice.entities.Employee;
import com.tss.employee_microservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.FOUND);
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable Long employeeId){
        return new ResponseEntity<>(employeeService.getEmployeesById(employeeId), HttpStatus.FOUND);
    }

    @GetMapping("/get-with-dept/{employeeId}")
    public ResponseEntity<ApiResponse> getEmployeesWithDeptById(@PathVariable Long employeeId){
        return new ResponseEntity<>(employeeService.getEmployeeWithDepartmentById(employeeId), HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addNewEmployee(@RequestBody EmployeeRequestDto request){
        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse> updateEmployee(@RequestBody UpdateDepartmentDto request){
        return new ResponseEntity<>(employeeService.updateEmployeeById(request), HttpStatus.OK);
    }
}
