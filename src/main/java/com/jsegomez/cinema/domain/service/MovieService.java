package com.jsegomez.cinema.domain.service;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;
import com.jsegomez.cinema.domain.exceptions.ResourceNotFoundException;
import com.jsegomez.cinema.domain.repository.MovieRepository;
import com.jsegomez.cinema.persistence.entity.MovieEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieDto> findAll() {
        return movieRepository.findAll();
    }

    public List<MovieDto> findAllByOrderByMvIdDesc() {
        return movieRepository.findAllByOrderByMvIdAsc();
    }

    public MovieDto findById(Long id) {
        return movieRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Movie", id) );
    }

    public MovieDto save(MovieDto movie) {
        return movieRepository.save(movie);
    }

    public MovieDto update(Long id, UpdateMovieDto movie) {
        return  null;
    }

    public boolean deleteById(Long id) {
        return movieRepository.deleteById(id);
    }

    public List<MovieDto> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
