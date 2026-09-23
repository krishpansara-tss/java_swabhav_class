package com.tssconsultancy.core.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentRequestDTO {
    @NotNull(message = "Name can't be Null")
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Min(value = 5, message = "Age must be greater than 5")
    @Max(value = 80, message = "Age must be less then 21")
    private  Integer age;

    private String city;
    private String state;
    private String pincode;
}
