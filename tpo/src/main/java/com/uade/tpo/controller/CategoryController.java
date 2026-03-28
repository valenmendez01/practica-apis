package com.uade.tpo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.service.CategoryService;
import com.uade.tpo.entity.Category;
import com.uade.tpo.repository.CategoryRepository;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// le indica a spring que esto es la capa de trafico
@RestController
// permite mapear los solicitudes http a localhost del back y las matchea con los endpoints
@RequestMapping("categories") // localhost:8080/categories

public class CategoryController {
    @GetMapping // localhost:8080/categories
    public ArrayList<Category> getCategories() {
        CategoryRepository categoryRepository = new CategoryRepository();

        return new categoryRepository.getCategories;
    }

    @GetMapping("/{categoryId}") // localhost:8080/categories/10
    public String getCategoryById(@PathVariable int categoryId) {
        return new String();
    }
    
    @PostMapping
    public String createCategory(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
