package com.assessment.dto;

import java.time.LocalDate;

public record AssessmentResponse(
        Long id,
        String employeeId,
        String assessmentName,
        String assessmentType,
        LocalDate startDate,
        LocalDate endDate,
        String status) {
}