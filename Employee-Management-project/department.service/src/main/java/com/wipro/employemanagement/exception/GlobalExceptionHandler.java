package com.wipro.employemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDepartmentNotFound(DepartmentNotFoundException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message", ex.getMessage());
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }
}
