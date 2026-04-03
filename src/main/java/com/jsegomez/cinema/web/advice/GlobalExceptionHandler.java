package com.jsegomez.cinema.web.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jsegomez.cinema.domain.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex){
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), List.of());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return buildResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String,Object>> handleUrlNotFound(NoResourceFoundException ex){
        String message = "URL not found: " + ex.getResourcePath();
        return buildResponse(HttpStatus.NOT_FOUND, message, List.of());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,Object>> handleNotReadable(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        String error;
        if (cause instanceof InvalidFormatException ife) {
            String field = ife.getPath().isEmpty() ? "unknown" : ife.getPath().get(0).getFieldName();
            error = field + ": Invalid value '" + ife.getValue() + "' for type " + ife.getTargetType().getSimpleName();
        } else {
            error = "Malformed JSON request";
        }
        return buildResponse(HttpStatus.BAD_REQUEST, "Invalid request body", List.of(error));
    }


    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, List<String> errors) {
        Map<String, Object> body = Map.of(
                "status", status.value(),
                "message", message,
                "errors", errors
        );
        return new ResponseEntity<>(body, status);
    }
}
