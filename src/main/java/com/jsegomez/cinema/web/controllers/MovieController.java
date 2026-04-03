package com.jsegomez.cinema.web.controllers;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;
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
        return ResponseEntity.ok(movieService.findAllByOrderByMvIdDesc());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.findByTitle(title));
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@Valid @RequestBody MovieDto movie) {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @Valid @RequestBody UpdateMovieDto movie) {
        return ResponseEntity.ok(movieService.update(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return movieService.deleteById(id)
                ? ResponseEntity.noContent().build()    // 204
                : ResponseEntity.notFound().build();     // 404
    }
}
