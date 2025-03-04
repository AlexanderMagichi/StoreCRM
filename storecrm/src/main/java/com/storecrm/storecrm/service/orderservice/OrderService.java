package com.storecrm.storecrm.service.orderservice;

import com.storecrm.storecrm.model.order.Order;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing orders.
 */
public interface OrderService {

    /**
     * Creates a new order.
     *
     * @param order the order to create.
     * @return the created order.
     */
    Order createOrder(Order order);

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order to retrieve.
     * @return an Optional containing the order if found, or Optional.empty if not.
     */
    Optional<Order> getOrderById(Long id);

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders.
     */
    List<Order> getAllOrders();

    /**
     * Updates an existing order.
     *
     * @param id    the ID of the order to update.
     * @param order the order data to update.
     * @return the updated order, or Optional.empty if the order was not found.
     */
    Optional<Order> updateOrder(Long id, Order order);

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete.
     * @return true if the order was deleted, false otherwise.
     */
    boolean deleteOrder(Long id);
}
