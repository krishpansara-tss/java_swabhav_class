package com.tssconsultancy.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentUpdateRequestDTO {

    private String name;
    private  Integer age;

    private String city;
    private String state;
    private String pincode;
}
