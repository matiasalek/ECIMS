package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.DTO.ProductsDTO;
import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.model.Products;
import com.ECommerceIMS.ECIMS.repository.CategoriesRepository;
import com.ECommerceIMS.ECIMS.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    public ProductsService (ProductsRepository productsRepository, CategoriesRepository categoriesRepository) {
        this.productsRepository = productsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Transactional
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }

    public Products createProduct(ProductsDTO productsDTO) {
        Categories categories = categoriesRepository.findById(productsDTO.getCategory_id())
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        Products products = new Products();

        products.setSku(productsDTO.getSku());
        products.setName(productsDTO.getName());
        products.setDescription(productsDTO.getDescription());
        products.setCategories(categories);
        products.setIs_Active(productsDTO.isIs_active());
        products.setCreated_at(productsDTO.getCreated_at());
        products.setUpdated_at(productsDTO.getUpdated_at());

        return productsRepository.save(products);
    }

    public Products updateProduct(Long id, ProductsDTO productsDTO) {
        Products products = getProductById(id);

        if (productsDTO.getCategory_id() != null && !products.getCategories().getCategory_id().equals(productsDTO.getCategory_id())) {
            Categories categories = categoriesRepository.findById(productsDTO.getCategory_id())
                    .orElseThrow(()-> new ResourceNotFoundException("Category not found"));
            products.setCategories(categories);
        }

        products.setSku(productsDTO.getSku());
        products.setName(productsDTO.getName());
        products.setDescription(productsDTO.getDescription());
        products.setIs_Active(productsDTO.isIs_active());
        products.setCreated_at(productsDTO.getCreated_at());
        products.setUpdated_at(productsDTO.getUpdated_at());

        return productsRepository.save(products);
    }

    public void deleteProduct(Long id) {
        if (!productsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productsRepository.deleteById(id);
    }
}
