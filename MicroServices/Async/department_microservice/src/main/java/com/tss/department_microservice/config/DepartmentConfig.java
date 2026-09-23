package com.tss.department_microservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConfig {

    @Value("${server.port}")
    private String port;

    public String getMessage(){
        return port;
    }
}
