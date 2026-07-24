package com.tssconsultancy.core.services;

import com.tssconsultancy.core.models.Employee;

import java.util.List;

public interface EmployeeServices {
    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(Long id);

    public Employee addNewEmployee(Employee employee);
}
