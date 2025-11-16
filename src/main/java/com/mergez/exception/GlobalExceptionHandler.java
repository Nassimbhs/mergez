package com.mergez.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        logger.error("Error occurred: ", ex);
        
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());
        error.put("exception", ex.getClass().getName());
        
        // Include stack trace details in development
        if (ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
            error.put("trace", ex.getStackTrace()[0].toString());
        }
        
        // If there's a root cause, include it
        Throwable rootCause = ex.getCause();
        if (rootCause != null) {
            error.put("rootCause", rootCause.getMessage());
            error.put("rootCauseClass", rootCause.getClass().getName());
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

