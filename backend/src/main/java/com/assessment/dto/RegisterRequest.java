package com.assessment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank String employeeId,        // must not be empty
        @NotBlank String name,
        @NotBlank @Email String email,      // must look like an email address
        @NotBlank @Size(min = 8, message = "Password must be at least 8 characters") String password) {
}