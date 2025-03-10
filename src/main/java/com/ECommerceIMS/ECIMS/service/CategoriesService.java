package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.repository.CategoriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Transactional
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Transactional
    public Categories getCategoriesById(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categories not found"));
    }

    public Categories createCategory(Categories categories) {
        if (categories.getCategory_id() != null) {
            throw new ResourceNotFoundException("Category already exist.");
        }
        return categoriesRepository.save(categories);
    }

    public Categories updateCategory(Long id, Categories categoryDetails) {
        return categoriesRepository.findById(id)
                .map(categories -> {
                    categories.setName(categoryDetails.getName());
                    categories.setDescription(categoryDetails.getDescription());
                    categories.setCreated_at(categoryDetails.getCreated_at());
                    categories.setUpdated_at(categoryDetails.getUpdated_at());
                    return categoriesRepository.save(categories);
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
    }

    public void deleteCategory(Long id) {
        if (!categoriesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found");
        }
        categoriesRepository.deleteById(id);
    }
}
