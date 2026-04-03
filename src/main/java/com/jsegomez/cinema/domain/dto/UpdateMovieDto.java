package com.jsegomez.cinema.domain.dto;

import com.jsegomez.cinema.persistence.entity.enums.MovieRating;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "Title is required")
        String title,

        @NotNull(message = "Release date is required")
        LocalDate releaseDate,

        @NotNull(message = "Rating is required")
        MovieRating rating
) { }
