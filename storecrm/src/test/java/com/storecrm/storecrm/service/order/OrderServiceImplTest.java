package com.storecrm.storecrm.service.order;

import com.storecrm.storecrm.model.order.Order;
import com.storecrm.storecrm.repository.order.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        order = Order.builder()
                .id(1L)
                .date(Timestamp.valueOf("2025-01-20 10:00:00"))
                .customerId(1001L)
                .status("PENDING")
                .totalAmount(150.75)
                .build();
    }

    @Test
    void testCreateOrder() {
        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals(order.getId(), createdOrder.getId());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testGetOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Optional<Order> foundOrder = orderService.getOrderById(1L);

        assertTrue(foundOrder.isPresent());
        assertEquals(order.getId(), foundOrder.get().getId());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = Arrays.asList(order);
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> allOrders = orderService.getAllOrders();

        assertEquals(1, allOrders.size());
        assertEquals(order.getId(), allOrders.get(0).getId());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testUpdateOrder() {
        Order updatedOrder = Order.builder()
                .id(1L)
                .date(Timestamp.valueOf("2025-01-21 12:00:00"))
                .customerId(1002L)
                .status("COMPLETED")
                .totalAmount(200.50)
                .build();

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        Optional<Order> result = orderService.updateOrder(1L, updatedOrder);

        assertTrue(result.isPresent());
        assertEquals("COMPLETED", result.get().getStatus());
        assertEquals(200.50, result.get().getTotalAmount());
        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testDeleteOrder() {
        when(orderRepository.existsById(1L)).thenReturn(true);

        boolean isDeleted = orderService.deleteOrder(1L);

        assertTrue(isDeleted);
        verify(orderRepository, times(1)).existsById(1L);
        verify(orderRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteOrder_NotFound() {
        when(orderRepository.existsById(1L)).thenReturn(false);

        boolean isDeleted = orderService.deleteOrder(1L);

        assertFalse(isDeleted);
        verify(orderRepository, times(1)).existsById(1L);
        verify(orderRepository, never()).deleteById(1L);
    }
}
