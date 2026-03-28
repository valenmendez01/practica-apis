package com.uade.tpo.service;

import java.util.ArrayList;

import com.uade.tpo.entity.Category;

// un servicio por cada uno de las requests
// sin anotaciones, esta capa de servicio no depende de ninguna libreria, solo trabaja en la logica de negocio con java
public class CategoryService {

    public ArrayList<Category> getCategories() {
        return new ArrayList<Category>();
    }

    public String getCategoryById(int categoryId) {
        return new String();
    }
    
    public String createCategory(String entity) {
        //TODO: process POST request
        
        return entity;
    }

}
