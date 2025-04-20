package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("SELECT i FROM Inventory i WHERE (i.quantity_on_hand + i.quantity_allocated) < i.reorder_threshold")
    List<Inventory> findItemsBelowThreshold();


    List<Inventory> findByProducts_Product_id(Long product_id);
    List<Inventory> findByWarehouses_Warehouse_id(Long warehouse_id);
}
