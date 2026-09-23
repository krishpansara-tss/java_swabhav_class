package com.tssconsultancy.core.dto;


import com.tssconsultancy.core.models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class StudentResponseDTO {
    private Long id;
    private String name;
    private Address address;
}
