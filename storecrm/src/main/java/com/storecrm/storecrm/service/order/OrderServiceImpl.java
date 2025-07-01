package com.storecrm.storecrm.service.order;

import com.storecrm.storecrm.model.order.Order;
import com.storecrm.storecrm.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the OrderService interface.
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        // Ensure mandatory fields are set if needed
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> updateOrder(Long id, Order order) {
        return orderRepository.findById(id).map(existingOrder -> {
            // Update fields in the existing order
            existingOrder.setDate(order.getDate());
            existingOrder.setCustomerId(order.getCustomerId());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setTotalAmount(order.getTotalAmount());
            return orderRepository.save(existingOrder);
        });
    }

    @Override
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
