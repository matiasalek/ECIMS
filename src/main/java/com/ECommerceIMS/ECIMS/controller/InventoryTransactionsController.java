package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.DTO.InventoryTransactionsDTO;
import com.ECommerceIMS.ECIMS.model.InventoryTransactions;
import com.ECommerceIMS.ECIMS.repository.InventoryTransactionsRepository;
import com.ECommerceIMS.ECIMS.service.InventoryTransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventorytransactions")
public class InventoryTransactionsController {
    private final InventoryTransactionsRepository inventoryTransactionsRepository;
    private final InventoryTransactionsService inventoryTransactionsService;

    public InventoryTransactionsController(InventoryTransactionsRepository inventoryTransactionsRepository,
                                           InventoryTransactionsService inventoryTransactionsService) {
        this.inventoryTransactionsRepository = inventoryTransactionsRepository;
        this.inventoryTransactionsService = inventoryTransactionsService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryTransactions>> getAllInventoryTransactions() {
        List<InventoryTransactions> inventoryTransactions = inventoryTransactionsService.getAllInventoryTransactions();
        return ResponseEntity.ok(inventoryTransactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransactions> getInventoryTransactionById(@PathVariable Long id) {
        InventoryTransactions inventoryTransactions = inventoryTransactionsService.getInventoryTransactionsById(id);
        return ResponseEntity.ok(inventoryTransactions);
    }

    @PostMapping
    public ResponseEntity<InventoryTransactions> createInventoryTransaction(@RequestBody InventoryTransactionsDTO inventoryTransactionsDTO) {
        InventoryTransactions createdInventoryTransactions = inventoryTransactionsService.createInventoryTransaction(inventoryTransactionsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInventoryTransactions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransactions> updateInventoryTransactions(@PathVariable Long id, @RequestBody InventoryTransactionsDTO inventoryTransactionsDTO) {
        InventoryTransactions updatedInventoryTransactions = inventoryTransactionsService.updateInventoryTransaction(id, inventoryTransactionsDTO);
        return ResponseEntity.ok(updatedInventoryTransactions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryTransactions> deleteInventoryTransactions(@PathVariable Long id) {
        inventoryTransactionsService.deleteInventoryTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inventory/{inventory_id}")
    public ResponseEntity<List<InventoryTransactions>> getInventoryTransactionsByInventoryId(@PathVariable Long inventory_id) {
        return ResponseEntity.ok(inventoryTransactionsService.getInventoryTransactionByInventoryId(inventory_id));
    }
}
