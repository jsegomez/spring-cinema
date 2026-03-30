package com.jsegomez.cinema.persistence.crud;

import com.jsegomez.cinema.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
}
