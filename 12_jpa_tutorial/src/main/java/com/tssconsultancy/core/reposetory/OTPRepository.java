package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Employee;
import com.tssconsultancy.core.models.OTPModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface OTPRepository extends JpaRepository<OTPModel, Long> {
    OTPModel findTopByEmailAndUsedFalseOrderByCreatedAtDesc(String email);
    long countByEmailAndCreatedAtAfter(String email, LocalDateTime time);
}
