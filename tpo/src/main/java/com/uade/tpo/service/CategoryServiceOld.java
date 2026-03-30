/*
package com.uade.tpo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uade.tpo.entity.Category;
import com.uade.tpo.exceptions.CategoryDuplicateException;
import com.uade.tpo.repository.CategoryRepository;

// Un servicio por cada uno de las requests
// Sin anotaciones (@), esta capa de servicio no depende de ninguna libreria, solo trabaja en la logica de negocio con java

public class CategoryServiceOld implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceOld() {
        categoryRepository = new CategoryRepository();
    }

    public ArrayList<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    public Optional<Category> getCategoryById(int categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }

    public Category createCategory(int newCategoryId, String description) throws CategoryDuplicateException {
        // servicio le pide al repositorio la lista completa de categorías
        ArrayList<Category> categories = categoryRepository.getCategories();
        // servicio se encarga de verificar que no exista una categoría con el mismo id y descripción. Si existe, lanza una excepción. Si no existe, le pide al repositorio que cree la nueva categoría.
        if (categories.stream().anyMatch(
                category -> category.getId() == newCategoryId && category.getDescription().equals(description)))
            throw new CategoryDuplicateException();
        
        // se le indica al repositorio que cree la nueva categoria
        return categoryRepository.createCategory(newCategoryId, description);
    }

}
*/