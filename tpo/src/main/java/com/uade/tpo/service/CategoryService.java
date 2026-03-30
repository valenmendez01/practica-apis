package com.uade.tpo.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.entity.Category;
import com.uade.tpo.exceptions.CategoryDuplicateException;

public interface CategoryService {

  public List<Category> getCategories();

  public Optional<Category> getCategoryById(Long categoryId);

  // public Category createCategory(Long newCategoryId, String description) throws CategoryDuplicateException;
  
}
