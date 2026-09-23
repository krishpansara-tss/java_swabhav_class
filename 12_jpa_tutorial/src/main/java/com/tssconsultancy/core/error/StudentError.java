package com.tssconsultancy.core.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class StudentError {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
