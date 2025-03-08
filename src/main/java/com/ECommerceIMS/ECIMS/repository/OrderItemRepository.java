package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
