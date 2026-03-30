package com.jsegomez.cinema.domain.exceptions;

public class NoResourceFoundException extends RuntimeException{

    public NoResourceFoundException(String resourceName, Long id) {
        super(resourceName + "not found with id: " + id);
    }
}
