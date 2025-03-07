package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
