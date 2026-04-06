package com.jsegomez.cinema.web.advice;

import java.util.List;

public record ErrorResponse(int status, String message, List<String> errors) {
}

