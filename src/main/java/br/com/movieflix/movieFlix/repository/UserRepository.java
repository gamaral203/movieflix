package br.com.movieflix.movieFlix.repository;

import br.com.movieflix.movieFlix.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
