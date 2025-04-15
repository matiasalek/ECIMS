package com.ECommerceIMS.ECIMS.DTO;

import com.ECommerceIMS.ECIMS.model.InventoryTransactions;

import java.time.LocalDateTime;

public class InventoryTransactionsDTO {
    private Long transaction_id;
    private Long inventory_id;
    private InventoryTransactions.TransactionType transactionType;
    private int quantity;
    private String notes;
    private LocalDateTime created_at;

    public InventoryTransactionsDTO () {}

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public InventoryTransactions.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(InventoryTransactions.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
