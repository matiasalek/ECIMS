package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.repository.CategoriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Transactional
    public Categories getCategoriesById(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categories not found"));
    }
}
