package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductsProductId(Long product_id);
    List<Inventory> findByWarehousesWarehouseId(Long warehouse_id);
}
