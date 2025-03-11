package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.model.Warehouses;
import com.ECommerceIMS.ECIMS.repository.WarehousesRepository;
import com.ECommerceIMS.ECIMS.service.WarehousesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehousesController {
    private final WarehousesRepository warehousesRepository;
    private final WarehousesService warehousesService;

    public WarehousesController (WarehousesRepository warehousesRepository, WarehousesService warehousesService) {
        this.warehousesRepository = warehousesRepository;
        this.warehousesService = warehousesService;
    }

    @GetMapping
    public ResponseEntity<List<Warehouses>> getAllWarehouses() {
        List<Warehouses> warehouses = warehousesService.getAllWarehouses();
        return ResponseEntity.ok(warehouses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouses> getWarehouseById(@PathVariable Long id) {
        Warehouses warehouses = warehousesService.getWarehouseById(id);
        return ResponseEntity.ok(warehouses);
    }

    @PostMapping
    public ResponseEntity<Warehouses> createWarehouse(@RequestBody Warehouses warehouses) {
        Warehouses createdWarehouse = warehousesService.createWarehouse(warehouses);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWarehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouses> updateWarehouse(@PathVariable Long id, @RequestBody Warehouses warehouseDetails) {
        Warehouses updatedWarehouse = warehousesService.updateWarehouse(id, warehouseDetails);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehousesService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
