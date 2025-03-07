package com.ECommerceIMS.ECIMS.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "warehouses")
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouse_id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private boolean is_active;

    @Column
    private LocalDate created_at;

    public long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
}
