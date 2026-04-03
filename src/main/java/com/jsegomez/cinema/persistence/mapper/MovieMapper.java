package com.jsegomez.cinema.persistence.mapper;

import com.jsegomez.cinema.domain.dto.MovieDto;
import com.jsegomez.cinema.persistence.entity.MovieEntity;
import com.jsegomez.cinema.domain.dto.UpdateMovieDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "id",          source = "mvId")
    @Mapping(target = "title",       source = "mvTitle")
    @Mapping(target = "duration",    source = "mvDuration")
    @Mapping(target = "score",       source = "mvScore")
    @Mapping(target = "releaseDate", source = "mvReleaseDate")
    @Mapping(target = "rating",      source = "mvRating")
    @Mapping(target = "available",   source = "mvAvailable")
    @Mapping(target = "genre",       source = "mvGenre")
    MovieDto toDto(MovieEntity entity);

    @InheritInverseConfiguration(name = "toDto")
    MovieEntity toEntity(MovieDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "mvTitle",       source = "title")
    @Mapping(target = "mvReleaseDate", source = "releaseDate")
    @Mapping(target = "mvRating",      source = "rating")
    @Mapping(target = "mvId",          ignore = true)
    @Mapping(target = "mvDuration",    ignore = true)
    @Mapping(target = "mvScore",       ignore = true)
    @Mapping(target = "mvGenre",       ignore = true)
    @Mapping(target = "mvAvailable",   ignore = true)
    void updateEntityFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);

    List<MovieDto> toDtoList(Iterable<MovieEntity> entities);
}
