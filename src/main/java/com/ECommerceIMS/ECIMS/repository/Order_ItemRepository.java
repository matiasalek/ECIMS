package com.ECommerceIMS.ECIMS.repository;

import com.ECommerceIMS.ECIMS.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_ItemRepository extends JpaRepository<Order_Item, Long> {
}
