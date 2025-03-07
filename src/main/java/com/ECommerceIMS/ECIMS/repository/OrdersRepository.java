package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
