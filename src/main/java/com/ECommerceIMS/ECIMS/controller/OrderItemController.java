package com.ECommerceIMS.ECIMS.controller;

import com.ECommerceIMS.ECIMS.DTO.OrderItemDTO;
import com.ECommerceIMS.ECIMS.model.OrderItem;
import com.ECommerceIMS.ECIMS.repository.OrderItemRepository;
import com.ECommerceIMS.ECIMS.service.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_item")
public class OrderItemController {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemService orderItemService;

    public OrderItemController (OrderItemRepository orderItemRepository,
                                OrderItemService orderItemService) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItem();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItem);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, orderItemDTO);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderItem> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orders/{order_id}")
    public ResponseEntity<List<OrderItem>> getOrderItemByOrderId(@PathVariable Long order_id) {
        return ResponseEntity.ok(orderItemService.getOrderItemByOrderId(order_id));
    }

    @GetMapping("/products/{product_id}")
    public ResponseEntity<List<OrderItem>> getOrderItemByProductId(@PathVariable Long product_id) {
        return ResponseEntity.ok(orderItemService.getOrderItemByProductId(product_id));
    }

    @GetMapping("/warehouses/{warehouse_id}")
    public ResponseEntity<List<OrderItem>> getOrderItemByWarehouseId(@PathVariable Long warehouse_id) {
        return ResponseEntity.ok(orderItemService.getOrderItemByWarehouseId(warehouse_id));
    }
}
