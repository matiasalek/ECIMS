package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.InventoryTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryTransactionsRepository extends JpaRepository<InventoryTransactions, Long> {
    List<InventoryTransactions> findByInventory_Inventory_id(Long inventory_id);
}
