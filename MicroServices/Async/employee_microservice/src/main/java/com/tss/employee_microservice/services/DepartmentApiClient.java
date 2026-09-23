package com.tss.employee_microservice.services;

import com.tss.employee_microservice.dtos.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-microservice")
public interface DepartmentApiClient {

    @GetMapping("/api/department/{departmentId}")
    Department getDepartmentById(@PathVariable Long departmentId);
}
