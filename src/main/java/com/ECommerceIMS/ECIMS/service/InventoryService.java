package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.DTO.InventoryDTO;
import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Inventory;
import com.ECommerceIMS.ECIMS.model.Products;
import com.ECommerceIMS.ECIMS.model.Warehouses;
import com.ECommerceIMS.ECIMS.repository.InventoryRepository;
import com.ECommerceIMS.ECIMS.repository.ProductsRepository;
import com.ECommerceIMS.ECIMS.repository.WarehousesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ProductsRepository productsRepository;
    private final WarehousesRepository warehousesRepository;

    public InventoryService (InventoryRepository inventoryRepository, ProductsRepository productsRepository, WarehousesRepository warehousesRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productsRepository = productsRepository;
        this.warehousesRepository = warehousesRepository;
    }

    @Transactional
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Inventory not found"));
    }

    public Inventory createInventory(InventoryDTO inventoryDTO) {
        Products products = productsRepository.findById(inventoryDTO.getProduct_id())
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));

        Warehouses warehouses = warehousesRepository.findById(inventoryDTO.getWarehouse_id())
                .orElseThrow(()-> new ResourceNotFoundException("Warehouse not found"));

        Inventory inventory = new Inventory();

        inventory.setProducts(products);
        inventory.setWarehouses(warehouses);
        inventory.setQuantity_on_hand(inventoryDTO.getQuantity_on_hand());
        inventory.setQuantity_allocated(inventoryDTO.getQuantity_allocated());
        inventory.setReorder_threshold(inventoryDTO.getReorder_threshold());
        inventory.setUpdated_at(inventoryDTO.getUpdated_at());

        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Long id, InventoryDTO inventoryDTO) {
        Inventory inventory = getInventoryById(id);

        if (inventoryDTO.getProduct_id() != null && !inventory.getProducts().getId().equals(inventoryDTO.getProduct_id())) {
            Products products = productsRepository.findById(inventoryDTO.getProduct_id())
                    .orElseThrow(()->new ResourceNotFoundException("Product not found"));
            inventory.setProducts(products);
        }

        if (inventoryDTO.getWarehouse_id() != null && !inventory.getWarehouses().getWarehouse_id().equals(inventoryDTO.getWarehouse_id())) {
            Warehouses warehouses = warehousesRepository.findById(inventoryDTO.getWarehouse_id())
                    .orElseThrow(()-> new ResourceNotFoundException("Warehouse not found"));
            inventory.setWarehouses(warehouses);
        }

        inventory.setQuantity_on_hand(inventoryDTO.getQuantity_on_hand());
        inventory.setQuantity_allocated(inventoryDTO.getQuantity_allocated());
        inventory.setReorder_threshold(inventoryDTO.getReorder_threshold());
        inventory.setUpdated_at(inventoryDTO.getUpdated_at());

        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Inventory not found");
        }
        inventoryRepository.deleteById(id);
    }

    public List<Inventory> getInventoryByProductId(Long product_id) {
        return inventoryRepository.findByProductsProductId(product_id);
    }

    public List<Inventory> getInventoryByWarehouseId(Long warehouse_id) {
        return inventoryRepository.findByWarehousesWarehouseId(warehouse_id);
    }
}
