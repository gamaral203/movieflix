package br.com.movieflix.movieFlix.service;

import br.com.movieflix.movieFlix.dto.StreamingDTO;
import br.com.movieflix.movieFlix.mapper.StreamingMapper;
import br.com.movieflix.movieFlix.model.StreamingModel;
import br.com.movieflix.movieFlix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;
    private final StreamingMapper streamingMapper;

    public StreamingService(StreamingRepository streamingRepository, StreamingMapper streamingMapper) {
        this.streamingRepository = streamingRepository;
        this.streamingMapper = streamingMapper;
    }

    //Criar Streaming
    public StreamingDTO saveStreaming(StreamingDTO streamingDTO) {
        StreamingModel streamingModel = streamingMapper.map(streamingDTO);
        streamingModel = streamingRepository.save(streamingModel);
        return streamingMapper.map(streamingModel);
    }

    //Listar todos os streamings

    public List<StreamingDTO> findAll() {
        List<StreamingModel> streamings = streamingRepository.findAll();
        return streamings.stream()
                .map(streamingMapper::map)
                .collect(Collectors.toList());
    }

    //Buscar por ID

    public StreamingDTO findById(Long id) {
        Optional<StreamingModel> streamingModel = streamingRepository.findById(id);
        return streamingModel.map(streamingMapper::map).orElse(null);
    }
    // Deletar por ID

    public void deleteById(Long id) {
        streamingRepository.deleteById(id);
    }
}
