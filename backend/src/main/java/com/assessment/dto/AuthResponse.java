package com.assessment.dto;

// token = the JWT, role = ADMIN or EMPLOYEE (Angular uses it to decide which page to show)
public record AuthResponse(String token, String role, String employeeId, String name) {
}