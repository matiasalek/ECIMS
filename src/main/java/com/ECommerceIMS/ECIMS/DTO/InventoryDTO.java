package com.ECommerceIMS.ECIMS.DTO;

import java.time.LocalDateTime;

public class InventoryDTO {
    private Long inventory_id;
    private Long product_id;
    private Long warehouse_id;
    private int quantity_on_hand;
    private int quantity_allocated;
    private int reorder_threshold;
    private LocalDateTime updated_at;

    public InventoryDTO () {}

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public int getQuantity_allocated() {
        return quantity_allocated;
    }

    public void setQuantity_allocated(int quantity_allocated) {
        this.quantity_allocated = quantity_allocated;
    }

    public int getReorder_threshold() {
        return reorder_threshold;
    }

    public void setReorder_threshold(int reorder_threshold) {
        this.reorder_threshold = reorder_threshold;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
