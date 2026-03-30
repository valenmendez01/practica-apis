package com.uade.tpo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.entity.Category;
import com.uade.tpo.exceptions.CategoryDuplicateException;
import com.uade.tpo.repository.CategoryRepository;

@Service // MARCA que estamos trabajando en capa servicio

public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // public Category createCategory(Long newCategoryId, String description) throws CategoryDuplicateException {
    //     // servicio le pide al repositorio la lista completa de categorías
    //     List<Category> categories = categoryRepository.findAll();
    //     // servicio se encarga de verificar que no exista una categoría con el mismo id y descripción. Si existe, lanza una excepción. Si no existe, le pide al repositorio que cree la nueva categoría.
    //     if (categories.stream().anyMatch(
    //             category -> category.getId() == newCategoryId && category.getDescription().equals(description)))
    //         throw new CategoryDuplicateException();
        
    //     // se le indica al repositorio que cree la nueva categoria
    //     return categoryRepository.save(newCategoryId, description);
    // }

}
