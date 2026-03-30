package com.jsegomez.cinema.persistence.mapper;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "id",          source = "mvId")
    @Mapping(target = "title",       source = "mvTitle")
    @Mapping(target = "duration",    source = "mvDuration")
    @Mapping(target = "score",       source = "mvScore")
    @Mapping(target = "ReleaseDate", source = "mvReleaseDate")
    @Mapping(target = "rating",      source = "mvRating")
    @Mapping(target = "available",   source = "mvAvailable")
    MovieDto toDto(MovieEntity entity);

    @InheritInverseConfiguration(name = "toDto")
    MovieEntity toEntity(MovieDto dto);

    List<MovieDto> toDtoList(Iterable<MovieEntity> entities);

    List<MovieEntity> toEntityList(List<MovieDto> dtos);
}
