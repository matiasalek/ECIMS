package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.OrderItem;
import com.ECommerceIMS.ECIMS.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrders_Order_id(Long order_id);
    List<OrderItem> findByProducts_Product_id(Long product_id);
    List<OrderItem> findByWarehouses_Warehouse_id(Long warehouse_id);
}
