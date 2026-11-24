package com.assessment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AssessmentRequest(
        @NotBlank String assessmentName,
        @NotBlank String assessmentType,
        @NotNull LocalDate startDate,     // @NotNull for non-text types like dates
        @NotNull LocalDate endDate) {
}