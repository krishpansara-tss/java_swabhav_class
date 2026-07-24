package com.tssconsultancy.core.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentRequestDTO {
    private String name;
    private  Integer age;
}
