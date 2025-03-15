package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProducts_Product_id(Long product_id);
    List<Inventory> findByWarehouses_Warehouse_id(Long warehouse_id);
}
