package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.DTO.InventoryDTO;
import com.ECommerceIMS.ECIMS.model.Inventory;
import com.ECommerceIMS.ECIMS.repository.InventoryRepository;
import com.ECommerceIMS.ECIMS.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;

    public InventoryController(InventoryRepository inventoryRepository, InventoryService inventoryService) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Inventory inventory = inventoryService.getInventoryById(id);
        return ResponseEntity.ok(inventory);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        Inventory createdInventory = inventoryService.createInventory(inventoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO) {
        Inventory updatedInventory = inventoryService.updateInventory(id, inventoryDTO);
        return ResponseEntity.ok(updatedInventory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inventory> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{product_id}")
    public ResponseEntity<List<Inventory>> getInventoryByProductId(@PathVariable Long product_id) {
        return ResponseEntity.ok(inventoryService.getInventoryByProductId(product_id));
    }

    @GetMapping("/warehouses/{warehouse_id}")
    public ResponseEntity<List<Inventory>> getInventoryByWarehouseId(@PathVariable Long warehouse_id) {
        return ResponseEntity.ok(inventoryService.getInventoryByWarehouseId(warehouse_id));
    }
}
