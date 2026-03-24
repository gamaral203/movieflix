package br.com.movieflix.movieFlix.controller;

import br.com.movieflix.movieFlix.dto.StreamingDTO;
import br.com.movieflix.movieFlix.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streamings")
public class StreamingController {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> saveStreaming(@RequestBody StreamingDTO streaming) {
        StreamingDTO streamingDTO = streamingService.saveStreaming(streaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingDTO.toString());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<StreamingDTO>> listAllCategories() {
        List<StreamingDTO> streamingDTOS = streamingService.findAll();
        return ResponseEntity.ok().body(streamingDTOS);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<?> getStreamingById(@PathVariable Long id) {
        StreamingDTO streamingDTO = streamingService.findById(id);

        if (streamingDTO != null) {
            return ResponseEntity.ok().body(streamingDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum streaming encontrado");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<String> deleteStreamingById(@PathVariable Long id) {
        if (streamingService.findById(id) != null) {
            streamingService.deleteById(id);
            return ResponseEntity.ok().body("id " + id + " Deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum streaming encontrado");
        }
    }
}
