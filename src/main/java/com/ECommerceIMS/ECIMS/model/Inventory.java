package com.ECommerceIMS.ECIMS.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventory_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouses warehouses;

    @Column
    private int quantity_on_hand;

    @Column
    private int quantity_allocated;

    @Column
    private int reorder_threshold;

    @Column
    private LocalDateTime updated_at;

    public Inventory(){}

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Warehouses getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Warehouses warehouses) {
        this.warehouses = warehouses;
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
