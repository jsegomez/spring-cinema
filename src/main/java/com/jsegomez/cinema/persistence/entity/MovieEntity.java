package com.jsegomez.cinema.persistence.entity;

import com.jsegomez.cinema.persistence.entity.enums.MovieGenre;
import com.jsegomez.cinema.persistence.entity.enums.MovieRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mv_id")
    private Long mvId;

    @Column(name = "mv_title", nullable = false)
    private String mvTitle;

    @Column(name = "mv_duration", nullable = false)
    private Integer mvDuration;

    @Column(name = "mv_score", precision = 4, scale = 2, nullable = false)
    private BigDecimal mvScore;

    @Column(name = "mv_release_date",  nullable = false )
    private LocalDate mvReleaseDate;

    @Column(name = "mv_rating",  nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieRating mvRating;

    @Column(name = "mv_genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre mvGenre;

    @Column(name = "mv_available", nullable = false)
    private Boolean mvAvailable;
}
