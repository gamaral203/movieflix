package br.com.movieflix.movieFlix.service;

import br.com.movieflix.movieFlix.dto.CategoryDTO;
import br.com.movieflix.movieFlix.mapper.CategoryMapper;
import br.com.movieflix.movieFlix.model.CategoryModel;
import br.com.movieflix.movieFlix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    //Listar todos as categorias
    public List<CategoryDTO> findAll() {
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());

    }

    //Criar Categorias
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
       CategoryModel categoryModel = categoryMapper.map(categoryDTO);
       categoryModel = categoryRepository.save(categoryModel);
       return categoryMapper.map(categoryModel);
    }
    //Buscar por ID
    public CategoryDTO findById(Long id) {
      Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
      return categoryModel.map(categoryMapper::map).orElse(null);
    }

    //Deletar por ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
