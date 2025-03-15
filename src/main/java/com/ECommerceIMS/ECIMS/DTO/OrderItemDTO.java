package com.ECommerceIMS.ECIMS.DTO;

public class OrderItemDTO {
    private Long order_item_id;
    private Long order_id;
    private Long product_id;
    private Long warehouse_id;
    private int quantity_order;
    private int quantity_allocated;

    public Long getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Long order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
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

    public int getQuantity_order() {
        return quantity_order;
    }

    public void setQuantity_order(int quantity_order) {
        this.quantity_order = quantity_order;
    }

    public int getQuantity_allocated() {
        return quantity_allocated;
    }

    public void setQuantity_allocated(int quantity_allocated) {
        this.quantity_allocated = quantity_allocated;
    }
}
