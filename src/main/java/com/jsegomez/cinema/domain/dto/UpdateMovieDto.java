package com.jsegomez.cinema.domain.dto;

import com.jsegomez.cinema.persistence.entity.enums.MovieRating;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UpdateMovieDto(

        @Size(min = 1, message = "Title must not be empty if provided")
        String title,

        LocalDate releaseDate,

        MovieRating rating
) { }
