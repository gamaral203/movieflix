package br.com.movieflix.movieFlix.mapper;

import br.com.movieflix.movieFlix.dto.MovieDTO;
import br.com.movieflix.movieFlix.model.MovieModel;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieModel map(MovieDTO movieDTO) {
        MovieModel movieModel = new MovieModel();
        movieModel.setId(movieDTO.getId());
        movieModel.setTitle(movieDTO.getTitle());
        movieModel.setDescription(movieDTO.getDescription());
        movieModel.setReleaseDate(movieDTO.getReleaseDate());
        movieModel.setUpdatedAt(movieDTO.getUpdatedAt());
        movieModel.setRating(movieDTO.getRating());
        return movieModel;


    }

    public MovieDTO map(MovieModel movieModel) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieModel.getId());
        movieDTO.setTitle(movieModel.getTitle());
        movieDTO.setDescription(movieModel.getDescription());
        movieDTO.setReleaseDate(movieModel.getReleaseDate());
        movieDTO.setUpdatedAt(movieModel.getUpdatedAt());
        movieDTO.setRating(movieModel.getRating());
        return movieDTO;

    }
}
