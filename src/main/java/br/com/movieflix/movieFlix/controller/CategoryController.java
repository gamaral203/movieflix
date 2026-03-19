package br.com.movieflix.movieFlix.controller;


import br.com.movieflix.movieFlix.dto.CategoryDTO;
import br.com.movieflix.movieFlix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOS = categoryService.findAll();
        return ResponseEntity.ok().body(categoryDTOS);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> saveCategory(@RequestBody CategoryDTO category) {
        CategoryDTO categoryDTO = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO.toString());
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.findById(id);

        if (categoryDTO != null) {
            return ResponseEntity.ok(categoryDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Nenhuma categoria encontrada");
        }
    }

    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        if (categoryService.findById(id) != null) {
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Categoria com o id " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma categoria encontrada");
        }
    }

}
