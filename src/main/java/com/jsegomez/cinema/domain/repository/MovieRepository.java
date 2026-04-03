package com.jsegomez.cinema.domain.repository;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<MovieDto> findAll();

    List<MovieDto> findAllByOrderByMvIdAsc();

    Optional<MovieDto> findById(Long id);

    MovieDto save(MovieDto movie);

    MovieDto update(Long id, UpdateMovieDto changes);

    boolean deleteById(Long id);

    boolean existsById(Long id);

    List<MovieDto> findByTitle(String title);
}
