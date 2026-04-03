package com.jsegomez.cinema.persistence;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;
import com.jsegomez.cinema.domain.exceptions.ResourceNotFoundException;
import com.jsegomez.cinema.domain.repository.MovieRepository;
import com.jsegomez.cinema.persistence.crud.CrudMovieEntity;
import com.jsegomez.cinema.persistence.entity.MovieEntity;
import com.jsegomez.cinema.persistence.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> findAll() {
        return this.movieMapper.toDtoList(crudMovieEntity.findAll());
    }

    @Override
    public List<MovieDto> findAllByOrderByMvIdAsc() {
        return this.movieMapper.toDtoList(crudMovieEntity.findAllByOrderByMvIdAsc());
    }

    @Override
    public Optional<MovieDto> findById(Long id) {
        return crudMovieEntity.findById(id).map(movieMapper::toDto);
    }

    @Override
    public MovieDto save(MovieDto movie) {
        MovieEntity movieEntity = movieMapper.toEntity(movie);
        return this.movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto changes) {
        MovieEntity movie = this.crudMovieEntity.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", id));

        movie.setMvTitle(changes.title());
        movie.setMvReleaseDate(changes.releaseDate());
        movie.setMvRating(changes.rating());

        return this.movieMapper.toDto(this.crudMovieEntity.save(movie));
    }

    @Override
    public boolean deleteById(Long id) {
        if (!crudMovieEntity.existsById(id)) {
            return false;
        }
        crudMovieEntity.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(Long id) {
        return crudMovieEntity.existsById(id);
    }

    @Override
    public List<MovieDto> findByTitle(String title) {
        return this.movieMapper.toDtoList(crudMovieEntity.findByMvTitleContainingIgnoreCase(title));
    }
}
