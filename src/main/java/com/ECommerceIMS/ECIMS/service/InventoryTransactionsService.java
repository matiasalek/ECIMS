package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.DTO.InventoryTransactionsDTO;
import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Inventory;
import com.ECommerceIMS.ECIMS.model.InventoryTransactions;
import com.ECommerceIMS.ECIMS.repository.InventoryRepository;
import com.ECommerceIMS.ECIMS.repository.InventoryTransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionsService {
    private final InventoryTransactionsRepository inventoryTransactionsRepository;
    private final InventoryRepository inventoryRepository;

    public InventoryTransactionsService(InventoryTransactionsRepository inventoryTransactionsRepository, InventoryRepository inventoryRepository) {
        this.inventoryTransactionsRepository = inventoryTransactionsRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public List<InventoryTransactions> getAllInventoryTransactions() { return inventoryTransactionsRepository.findAll(); }

    public InventoryTransactions getInventoryTransactionsById(Long id) {
        return inventoryTransactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inventory Transaction not found"));
    }

    public InventoryTransactions createInventoryTransaction(InventoryTransactionsDTO inventoryTransactionsDTO) {
        Inventory inventory = inventoryRepository.findById(inventoryTransactionsDTO.getInventory_id())
                .orElseThrow(()-> new ResourceNotFoundException("Inventory not found"));

        InventoryTransactions inventoryTransactions = new InventoryTransactions();

        inventoryTransactions.setInventory(inventory);
        inventoryTransactions.setTransactionType(inventoryTransactionsDTO.getTransactionType());
        inventoryTransactions.setQuantity(inventoryTransactionsDTO.getQuantity());
        inventoryTransactions.setNotes(inventoryTransactionsDTO.getNotes());
        inventoryTransactions.setCreated_at(inventoryTransactionsDTO.getCreated_at());

        return inventoryTransactionsRepository.save(inventoryTransactions);
    }

    public InventoryTransactions updateInventoryTransaction(Long id, InventoryTransactionsDTO inventoryTransactionsDTO) {
        InventoryTransactions inventoryTransactions = getInventoryTransactionsById(id);

        if (inventoryTransactionsDTO.getInventory_id() != null && !inventoryTransactions.getInventory()
                .getInventory_id()
                .equals(inventoryTransactionsDTO.getInventory_id())) {
            Inventory inventory = inventoryRepository.findById(inventoryTransactionsDTO.getInventory_id())
                    .orElseThrow(()->new ResourceNotFoundException("Inventory not found"));
            inventoryTransactions.setInventory(inventory);
        }

        inventoryTransactions.setTransactionType(inventoryTransactionsDTO.getTransactionType());
        inventoryTransactions.setQuantity(inventoryTransactionsDTO.getQuantity());
        inventoryTransactions.setNotes(inventoryTransactionsDTO.getNotes());
        inventoryTransactions.setCreated_at(inventoryTransactionsDTO.getCreated_at());

        return inventoryTransactionsRepository.save(inventoryTransactions);
    }

    public void deleteInventoryTransaction(Long id) {
        if (!inventoryTransactionsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Inventory Transaction not found");
        }
        inventoryTransactionsRepository.deleteById(id);
    }

    public List<InventoryTransactions> getInventoryTransactionByInventoryId(Long inventory_id) {
        return inventoryTransactionsRepository.findByInventory_Inventory_id(inventory_id);
    }
}
