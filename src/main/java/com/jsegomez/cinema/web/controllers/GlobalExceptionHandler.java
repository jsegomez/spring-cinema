package com.jsegomez.cinema.web.controllers;

import com.jsegomez.cinema.domain.exceptions.NoResourceFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNoResourceFoundException(NoResourceFoundException ex){
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), List.of(ex.getMessage()));
    }

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, List<String> errors) {
        Map<String, Object> body = Map.of(
                "status", status.value(),
                "message", message,
                "errors", errors
        );
        return new ResponseEntity<>(body, status);
    };
}
