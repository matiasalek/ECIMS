package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findByCategories_Category_id(Long category_id);
}
