package com.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice   // applies to every controller, and returns JSON
public class GlobalExceptionHandler {

    // Our own errors, e.g. "Employee ID is already registered"
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApi(ApiException ex) {
        return body(ex.getStatus(), ex.getMessage());
    }

    // Triggered when @Valid fails, e.g. blank name or bad email
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return body(HttpStatus.BAD_REQUEST, message);   // 400
    }

    // Wrong password at login
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> handleBadCredentials(BadCredentialsException ex) {
        return body(HttpStatus.UNAUTHORIZED, "Invalid employee ID or password");   // 401
    }

    // Logged in, but not allowed (employee calling an admin API)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleDenied(AccessDeniedException ex) {
        return body(HttpStatus.FORBIDDEN, "You do not have permission to do this");   // 403
    }

    // One helper, so every error has the same JSON shape
    private ResponseEntity<Map<String, Object>> body(HttpStatus status, String message) {
        Map<String, Object> map = new LinkedHashMap<>();   // keeps the field order
        map.put("timestamp", LocalDateTime.now().toString());
        map.put("status", status.value());
        map.put("message", message);
        return ResponseEntity.status(status).body(map);
    }
}