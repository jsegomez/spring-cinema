package com.jsegomez.cinema.domain.dto;

import com.jsegomez.cinema.persistence.entity.enums.MovieRating;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Long id,

        @NotBlank(message = "Title is required")
        String title,

        @NotNull(message = "Duration is required")
        @Positive(message = "Duration must be a positive number")
        Integer duration,

        @NotNull(message = "Score is required")
        @DecimalMin(value = "0.0", message = "Score must be at least 0.0")
        @DecimalMax(value = "10.0", message = "Score must be at most 10.0")
        BigDecimal score,

        @NotNull(message = "Release date is required")
        LocalDate ReleaseDate,

        @NotNull(message = "Rating is required")
        MovieRating rating,

        @NotNull(message = "Available is required")
        Boolean available
) {
}
