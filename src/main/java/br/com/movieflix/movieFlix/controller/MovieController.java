package br.com.movieflix.movieFlix.controller;

import br.com.movieflix.movieFlix.dto.MovieDTO;
import br.com.movieflix.movieFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/criar")
    public ResponseEntity<String> saveMovie(@RequestBody MovieDTO movie) {
        MovieDTO movieDTO = movieService.saveMovie(movie);
        return ResponseEntity.ok(movieDTO.toString());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovieDTO>> listAllMovies() {
        List<MovieDTO> moviesDTOS = movieService.findAllMovies();
        return ResponseEntity.ok(moviesDTOS);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.findMovieById(id);
        if (movieDTO != null) {
            return ResponseEntity.ok().body(movieDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Filme foi encontrado");
        }
    }
    @DeleteMapping("/deletarPorId/{Id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id){
        if (movieService.findMovieById(id) != null) {
            movieService.deleteMovieById(id);
            return ResponseEntity.ok(" Id " + id + " deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Filme foi encontrado");
        }
    }
}
