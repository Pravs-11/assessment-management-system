package com.assessment.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {   // unchecked, so no "throws" clauses needed

    private final HttpStatus status;                   // e.g. 404 NOT_FOUND, 409 CONFLICT

    public ApiException(HttpStatus status, String message) {
        super(message);                                // message shown to the user
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}