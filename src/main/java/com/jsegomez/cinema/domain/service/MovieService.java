package com.jsegomez.cinema.domain.service;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.exceptions.ResourceNotFoundException;
import com.jsegomez.cinema.domain.repository.MovieRepository;
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

    public MovieDto findById(Long id) {
        return movieRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Movie", id) );
    }

    public boolean deleteById(Long id) {
        return movieRepository.deleteById(id);
    }
}
