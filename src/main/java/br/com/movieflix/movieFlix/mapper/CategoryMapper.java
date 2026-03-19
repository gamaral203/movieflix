package br.com.movieflix.movieFlix.mapper;


import br.com.movieflix.movieFlix.dto.CategoryDTO;
import br.com.movieflix.movieFlix.model.CategoryModel;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {

    public CategoryModel map(CategoryDTO categoryDTO) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryDTO.getId());
        categoryModel.setName(categoryDTO.getName());
        return categoryModel;
    }

    public CategoryDTO map(CategoryModel categoryModel) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryModel.getId());
        categoryDTO.setName(categoryModel.getName());
        return categoryDTO;
    }
}
