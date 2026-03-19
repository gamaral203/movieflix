package br.com.movieflix.movieFlix.mapper;

import br.com.movieflix.movieFlix.dto.StreamingDTO;
import br.com.movieflix.movieFlix.model.StreamingModel;
import org.springframework.stereotype.Component;

@Component
public class StremingMapper {
    public StreamingModel map(StreamingDTO streamingDTO) {
        StreamingModel streamingModel = new StreamingModel();
        streamingModel.setId(streamingDTO.getId());
        streamingModel.setTitle(streamingDTO.getTitle());
        return streamingModel;
    }

    public StreamingDTO map(StreamingModel streamingModel) {
        StreamingDTO streamingDTO = new StreamingDTO();
        streamingDTO.setId(streamingModel.getId());
        streamingDTO.setTitle(streamingModel.getTitle());
        return streamingDTO;
    }
}
