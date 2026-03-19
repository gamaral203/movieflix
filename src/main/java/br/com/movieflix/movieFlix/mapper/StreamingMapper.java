package br.com.movieflix.movieFlix.mapper;

import br.com.movieflix.movieFlix.dto.StreamingDTO;
import br.com.movieflix.movieFlix.model.StreamingModel;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {
    public StreamingModel map(StreamingDTO streamingDTO) {
        StreamingModel streamingModel = new StreamingModel();
        streamingModel.setId(streamingDTO.getId());
        streamingModel.setName(streamingDTO.getName());
        return streamingModel;
    }

    public StreamingDTO map(StreamingModel streamingModel) {
        StreamingDTO streamingDTO = new StreamingDTO();
        streamingDTO.setId(streamingModel.getId());
        streamingDTO.setName(streamingModel.getName());
        return streamingDTO;
    }
}
