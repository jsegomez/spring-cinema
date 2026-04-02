package com.jsegomez.cinema.persistence.crud;

import com.jsegomez.cinema.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudMovieEntity extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findAllByOrderByMvIdAsc();

    List<MovieEntity> findByMvTitleContainingIgnoreCase(String mvTitle);
}
