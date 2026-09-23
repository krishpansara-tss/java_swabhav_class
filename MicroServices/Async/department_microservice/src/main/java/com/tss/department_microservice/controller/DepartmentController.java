package com.tss.department_microservice.controller;

import com.tss.department_microservice.config.DepartmentConfig;
import com.tss.department_microservice.entites.Department;
import com.tss.department_microservice.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentConfig departmentConfig;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllEmployees(){
        return new ResponseEntity<>(departmentService.getAllDepartment(), HttpStatus.FOUND);
    }

    @GetMapping("/port")
    public ResponseEntity<String> getPort(){
        return new ResponseEntity<>(departmentConfig.getMessage(), HttpStatus.FOUND);
    }


    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getEmployeesById(@PathVariable Long departmentId){
        Department response = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(response);
    }
}
