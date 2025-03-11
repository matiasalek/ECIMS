package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Categories;
import com.ECommerceIMS.ECIMS.model.Warehouses;
import com.ECommerceIMS.ECIMS.repository.WarehousesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousesService {
    private final WarehousesRepository warehousesRepository;

    public WarehousesService(WarehousesRepository warehousesRepository) {
        this.warehousesRepository = warehousesRepository;
    }

    @Transactional
    public List<Warehouses> getAllWarehouses() {
        return warehousesRepository.findAll();
    }

    @Transactional
    public Warehouses getWarehouseById(Long id) {
        return warehousesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Warehouse not found"));
    }

    public Warehouses createWarehouse(Warehouses warehouse) {
        if (warehouse.getWarehouse_id() != null) {
            throw new ResourceNotFoundException("Warehouse not found");
        }
        return warehousesRepository.save(warehouse);
    }

    public Warehouses updateWarehouse(Long id, Warehouses warehouseDetails) {
        return warehousesRepository.findById(id)
                .map(warehouses -> {
                    warehouses.setName(warehouseDetails.getName());
                    warehouses.setLocation(warehouseDetails.getLocation());
                    warehouses.setIs_active(warehouseDetails.isIs_active());
                    warehouses.setCreated_at(warehouseDetails.getCreated_at());
                    return warehousesRepository.save(warehouses);
                }).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id " + id));
    }

    public void deleteWarehouse(Long id) {
        if (!warehousesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Warehouse not found");
        }
        warehousesRepository.deleteById(id);
    }
}
