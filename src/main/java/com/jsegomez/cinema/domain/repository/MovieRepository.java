package com.jsegomez.cinema.domain.repository;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<MovieDto> findAllByOrderByMvIdAsc();

    Optional<MovieDto> findById(Long id);

    MovieDto save(MovieDto movie);

    Optional<MovieDto> update(Long id, UpdateMovieDto changes);

    void deleteById(Long id);

    List<MovieDto> findByTitle(String title);
}
