package com.jsegomez.cinema.web.controllers;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@Valid @RequestBody MovieDto movie) {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return movieService.deleteById(id)
                ? ResponseEntity.noContent().build()    // 204
                : ResponseEntity.notFound().build();     // 404
    }
}
