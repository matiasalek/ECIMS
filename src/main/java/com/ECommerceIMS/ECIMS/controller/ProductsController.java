package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.DTO.ProductsDTO;
import com.ECommerceIMS.ECIMS.model.Products;
import com.ECommerceIMS.ECIMS.repository.ProductsRepository;
import com.ECommerceIMS.ECIMS.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductsRepository productsRepository;
    private final ProductsService productsService;

    public ProductsController (ProductsRepository productsRepository, ProductsService productsService) {
        this.productsRepository = productsRepository;
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products products = productsService.getProductById(id);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody ProductsDTO productsDTO) {
        Products createdProduct = productsService.createProduct(productsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) {
        Products updatedProduct = productsService.updateProduct(id, productsDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<Products>> getProductByCategoryId(@PathVariable long categoryId) {
        return ResponseEntity.ok(productsService.getProductByCategoryId(categoryId));
    }
}