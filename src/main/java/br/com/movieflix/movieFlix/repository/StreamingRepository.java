package br.com.movieflix.movieFlix.repository;

import br.com.movieflix.movieFlix.model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {

}
