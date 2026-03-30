package com.jsegomez.cinema.persistence;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.repository.MovieRepository;
import com.jsegomez.cinema.persistence.crud.CrudMovieEntity;
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
    public Optional<MovieDto> findById(Long id) {
        return crudMovieEntity.findById(id).map(movieMapper::toDto);
    }

    @Override
    public MovieDto save(MovieDto movie) {
        return null;
    }

    @Override
    public Optional<MovieDto> update(Long id, MovieDto movie) {
        return Optional.empty();
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
}
