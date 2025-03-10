package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.repository.CategoriesRepository;
import com.ECommerceIMS.ECIMS.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoriesRepository categoriesRepository;
    private final CategoriesService categoriesService;

    public CategoriesController (CategoriesRepository categoriesRepository, CategoriesService categoriesService) {
        this.categoriesRepository = categoriesRepository;
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable Long id) {
        Categories categories = categoriesService.getCategoriesById(id);
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Categories> createCategory(@RequestBody Categories categories) {
        Categories createdCategory = categoriesService.createCategory(categories);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories categoryDetails) {
        Categories updatedCategory = categoriesService.updateCategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
