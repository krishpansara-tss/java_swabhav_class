package com.tss.department_microservice.services;

import com.tss.department_microservice.entites.Department;
import com.tss.department_microservice.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("Department having id " + departmentId + " doesn't exists.")
        );
    }
}
