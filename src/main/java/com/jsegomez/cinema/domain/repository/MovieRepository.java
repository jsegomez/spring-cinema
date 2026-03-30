package com.jsegomez.cinema.domain.repository;

import com.jsegomez.cinema.domain.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<MovieDto> findAll();

    Optional<MovieDto> findById(Long id);

    MovieDto save(MovieDto movie);

    Optional<MovieDto> update(Long id, MovieDto movie);

    boolean deleteById(Long id);

    boolean existsById(Long id);
}
