package br.com.movieflix.movieFlix.repository;

import br.com.movieflix.movieFlix.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
