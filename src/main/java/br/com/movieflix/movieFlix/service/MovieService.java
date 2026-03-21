package br.com.movieflix.movieFlix.service;

import br.com.movieflix.movieFlix.dto.MovieDTO;
import br.com.movieflix.movieFlix.mapper.CategoryMapper;
import br.com.movieflix.movieFlix.mapper.MovieMapper;
import br.com.movieflix.movieFlix.model.MovieModel;
import br.com.movieflix.movieFlix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryMapper categoryMapper;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, CategoryMapper categoryMapper, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.categoryMapper = categoryMapper;
        this.movieMapper = movieMapper;
    }


    //Criar Movie
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        MovieModel movieModel = movieMapper.map(movieDTO);
        movieModel = movieRepository.save(movieModel);
        return movieMapper.map(movieModel);
    }

    // Listar todos os Movies
    public List<MovieDTO> findAllMovies() {
        List<MovieModel> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::map)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public MovieDTO findMovieById(Long id) {
        Optional<MovieModel> movieModel = movieRepository.findById(id);
        return movieModel.map(movieMapper::map).orElse(null);
    }

    // Deletar por ID
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
