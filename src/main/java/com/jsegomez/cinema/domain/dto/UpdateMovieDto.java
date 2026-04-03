package com.jsegomez.cinema.domain.dto;

import com.jsegomez.cinema.persistence.entity.enums.MovieRating;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        MovieRating rating
) { }
