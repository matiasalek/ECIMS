package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Products;
import com.ECommerceIMS.ECIMS.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService (ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Transactional
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Transactional
    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }

    public Products createProduct(Products products) {
        if (products.getId() != null) {
            throw new ResourceNotFoundException("Product alredy exist.");
        }
        return productsRepository.save(products);
    }

    public Products updateProduct(Long id, Products productDetails) {
        return productsRepository.findById(id)
                .map(products -> {
                    products.setSku(productDetails.getSku());
                    products.setName(productDetails.getName());
                    products.setDescription(productDetails.getDescription());
                    products.setIs_Active(productDetails.isIs_Active());
                    products.setCreated_at(productDetails.getCreated_at());
                    products.setUpdated_at(productDetails.getUpdated_at());
                    return productsRepository.save(products);
                }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    public void deleteProduct(Long id) {
        if (!productsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productsRepository.deleteById(id);
    }
}
