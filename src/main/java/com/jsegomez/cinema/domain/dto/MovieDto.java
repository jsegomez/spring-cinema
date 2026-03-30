package com.jsegomez.cinema.domain.dto;

import com.jsegomez.cinema.persistence.entity.enums.MovieRating;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        BigDecimal score,
        LocalDate ReleaseDate,
        MovieRating rating,
        Boolean available
) {
}
