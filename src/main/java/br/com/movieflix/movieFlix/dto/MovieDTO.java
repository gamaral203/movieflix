package br.com.movieflix.movieFlix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;


    private String title;


    private String description;


    private LocalDate releaseDate;


    private double rating;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;


    private List<Long> categoryIds;

    private List<Long> streamingIds;
}
