package br.com.movieflix.movieFlix.controller;

import br.com.movieflix.movieFlix.controller.request.CategoryRequest;
import br.com.movieflix.movieFlix.controller.response.CategoryResponse;
import br.com.movieflix.movieFlix.model.CategoryModel;
import br.com.movieflix.movieFlix.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listar")
    public List<CategoryResponse> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/criar")
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request) {
        return categoryService.saveCategory(request);
    }

    @GetMapping("/listarPorId/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        Optional<CategoryModel> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()) {
            return optCategory.get();
        }
        return null;
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
