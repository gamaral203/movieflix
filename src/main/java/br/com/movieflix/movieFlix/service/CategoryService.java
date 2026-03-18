package br.com.movieflix.movieFlix.service;

import br.com.movieflix.movieFlix.model.CategoryModel;
import br.com.movieflix.movieFlix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> findAll() {
        return  categoryRepository.findAll();
    }
    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }
    public Optional<CategoryModel> findById(Long id) {
        return categoryRepository.findById(id);
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
