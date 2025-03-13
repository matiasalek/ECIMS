package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
