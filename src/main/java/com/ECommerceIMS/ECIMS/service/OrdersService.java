package com.ECommerceIMS.ECIMS.service;

import com.ECommerceIMS.ECIMS.exception.ResourceNotFoundException;
import com.ECommerceIMS.ECIMS.model.Orders;
import com.ECommerceIMS.ECIMS.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Transactional
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found"));
    }

    public Orders createOrder(Orders order) {
        if (order.getOrder_id() != null) {
            throw new ResourceNotFoundException("Order not found");
        }
        return ordersRepository.save(order);
    }

    public Orders updateOrder(Long id, Orders orderDetails) {
        return ordersRepository.findById(id)
                .map(orders -> {
                    orders.setOrder_number(orderDetails.getOrder_number());
                    orders.setStatus(orderDetails.getStatus());
                    orders.setCreated_at(orderDetails.getCreated_at());
                    orders.setUpdated_at(orderDetails.getUpdated_at());
                    return ordersRepository.save(orders);
                }).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    public void deleteOrder(Long id) {
        if (!ordersRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order not found");
        }
        ordersRepository.deleteById(id);
    }
}
