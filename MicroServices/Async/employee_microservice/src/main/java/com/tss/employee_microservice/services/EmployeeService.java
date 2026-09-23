package com.tss.employee_microservice.services;

import com.tss.employee_microservice.dtos.*;
import com.tss.employee_microservice.entities.Employee;
import com.tss.employee_microservice.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final DepartmentApiClient departmentApiClient;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeesById(Long employeeId){
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Employee having id " + employeeId + " doesn't exists.")
        );
    }

    public ApiResponse getEmployeeWithDepartmentById(Long employeeId){
        Employee employee = getEmployeesById(employeeId);

//        ResponseEntity<Department> departmentDto = restTemplate.getForEntity("http://localhost:8082/api/department/" + employee.getDepartmentId(), Department.class);

//        apiResponse.setDepartment(departmentDto.getBody());
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId(employee.getEmployeeId());
//        employeeDto.setEmployeeName(employee.getEmployeeName());
//        apiResponse.setEmployeeDto(employeeDto);
        Department department = departmentApiClient.getDepartmentById(employee.getDepartmentId());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setDepartment(department);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        apiResponse.setEmployeeDto(employeeDto);

        return apiResponse;
    }

    public ApiResponse addEmployee(EmployeeRequestDto request){
        ApiResponse apiResponse = new ApiResponse();

        Department department = departmentApiClient.getDepartmentById(request.getDepartmentId());

        Employee employee = new Employee();
        employee.setEmployeeName(request.getEmployeeName());
        employee.setDepartmentId(request.getDepartmentId());

        employee = employeeRepository.save(employee);

        apiResponse.setDepartment(department);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        apiResponse.setEmployeeDto(employeeDto);

        return  apiResponse;
    }

    public ApiResponse updateEmployeeById(UpdateDepartmentDto request){
        ApiResponse apiResponse = new ApiResponse();

        Employee employee = getEmployeesById(request.getEmployeeId());
        Department department = departmentApiClient.getDepartmentById(request.getDepartmentId());

        employee.setDepartmentId(department.getDepartmentId());

        employee = employeeRepository.save(employee);

        apiResponse.setDepartment(department);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        apiResponse.setEmployeeDto(employeeDto);

        return apiResponse;
    }
}
