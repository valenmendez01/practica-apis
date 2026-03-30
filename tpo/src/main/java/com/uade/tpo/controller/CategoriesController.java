package com.uade.tpo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.service.CategoryService;
import com.uade.tpo.service.CategoryServiceImp;
import com.uade.tpo.entity.Category;
import com.uade.tpo.entity.dto.CategoryRequest;
import com.uade.tpo.exceptions.CategoryDuplicateException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // MARCA que estamos trabajando en capa servicio

@RequestMapping("categories")

public class CategoriesController {

    @Autowired // Implementa la interfaz CategoryService
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        Optional<Category> result = categoryService.getCategoryById(categoryId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }
    
    // @PostMapping
    // public ResponseEntity<Object> createCategory(@RequestBody CategoryRequest categoryRequest)
    //         throws CategoryDuplicateException {
    //     Category result = categoryService.createCategory(categoryRequest.getId(), categoryRequest.getDescription());
    //     return ResponseEntity.created(URI.create("/categories/" + result.getId())).body(result);
    // }
    
}