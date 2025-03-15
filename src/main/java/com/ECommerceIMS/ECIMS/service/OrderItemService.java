package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.DTO.OrderItemDTO;
import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.OrderItem;
import com.ECommerceIMS.ECIMS.model.Orders;
import com.ECommerceIMS.ECIMS.model.Products;
import com.ECommerceIMS.ECIMS.model.Warehouses;
import com.ECommerceIMS.ECIMS.repository.OrderItemRepository;
import com.ECommerceIMS.ECIMS.repository.OrdersRepository;
import com.ECommerceIMS.ECIMS.repository.ProductsRepository;
import com.ECommerceIMS.ECIMS.repository.WarehousesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;
    private final WarehousesRepository warehousesRepository;

    public OrderItemService (OrderItemRepository orderItemRepository,
                             OrdersRepository ordersRepository,
                             ProductsRepository productsRepository,
                             WarehousesRepository warehousesRepository) {
        this.orderItemRepository = orderItemRepository;
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
        this.warehousesRepository = warehousesRepository;
    }

    @Transactional
    public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Order item not found"));
    }

    public OrderItem createOrderItem(OrderItemDTO orderItemDTO) {
        Orders orders = ordersRepository.findById(orderItemDTO.getOrder_id())
                .orElseThrow(()-> new ResourceNotFoundException("Order not found"));

        Products products = productsRepository.findById(orderItemDTO.getProduct_id())
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));

        Warehouses warehouses = warehousesRepository.findById(orderItemDTO.getWarehouse_id())
                .orElseThrow(()-> new ResourceNotFoundException("Warehouse not found"));

        OrderItem orderItem = new OrderItem();

        orderItem.setOrders(orders);
        orderItem.setProducts(products);
        orderItem.setWarehouses(warehouses);
        orderItem.setQuantity_order(orderItemDTO.getQuantity_order());
        orderItem.setQuantity_allocated(orderItemDTO.getQuantity_allocated());

        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItemDTO orderItemDTO) {
        OrderItem orderItem = getOrderItemById(id);

        if (orderItemDTO.getOrder_id() != null && !orderItem.getOrders().getOrder_id().equals(orderItemDTO.getOrder_id())) {
            Orders orders = ordersRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Order not found"));
            orderItem.setOrders(orders);
        }

        if (orderItemDTO.getProduct_id() != null && !orderItem.getProducts().getId().equals(orderItemDTO.getProduct_id())) {
            Products products = productsRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Product not found"));
            orderItem.setProducts(products);
        }

        if (orderItemDTO.getWarehouse_id() != null && !orderItem.getWarehouses().getWarehouse_id().equals(orderItemDTO.getWarehouse_id())) {
            Warehouses warehouses = warehousesRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("Warehouse not found"));
            orderItem.setWarehouses(warehouses);
        }

        orderItem.setQuantity_order(orderItemDTO.getQuantity_order());
        orderItem.setQuantity_allocated(orderItemDTO.getQuantity_allocated());

        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order item not found");
        }
        orderItemRepository.deleteById(id);
    }

    public List<OrderItem> getOrderItemByOrderId(Long order_id) {
        return orderItemRepository.findByOrders_Order_id(order_id);
    }

    public List<OrderItem> getOrderItemByProductId(Long product_id) {
        return orderItemRepository.findByProducts_Product_id(product_id);
    }

    public List<OrderItem> getOrderItemByWarehouseId(Long warehouse_id) {
        return orderItemRepository.findByWarehouses_Warehouse_id(warehouse_id);
    }
}
