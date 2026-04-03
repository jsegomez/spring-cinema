package com.jsegomez.cinema.persistence;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;
import com.jsegomez.cinema.domain.repository.MovieRepository;
import com.jsegomez.cinema.persistence.crud.CrudMovieEntity;
import com.jsegomez.cinema.persistence.entity.MovieEntity;
import com.jsegomez.cinema.persistence.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> findAllByOrderByMvIdAsc() {
        return this.movieMapper.toDtoList(crudMovieEntity.findAllByOrderByMvIdAsc());
    }

    @Override
    public Page<MovieDto> findAllPaged(Pageable pageable) {
        return crudMovieEntity.findAll(pageable).map(movieMapper::toDto);
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
    public Optional<MovieDto> update(Long id, UpdateMovieDto changes) {
        return this.crudMovieEntity.findById(id)
                .map(movie -> {
                    this.movieMapper.updateEntityFromDto(changes, movie);
                    return this.movieMapper.toDto(this.crudMovieEntity.save(movie));
                });
    }

    @Override
    public void deleteById(Long id) {
        crudMovieEntity.deleteById(id);
    }

    @Override
    public List<MovieDto> findByTitle(String title) {
        return this.movieMapper.toDtoList(crudMovieEntity.findByMvTitleContainingIgnoreCase(title));
    }
}
