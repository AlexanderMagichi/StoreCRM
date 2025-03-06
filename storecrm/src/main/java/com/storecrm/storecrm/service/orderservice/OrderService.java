package com.storecrm.storecrm.service.orderservice;

import com.storecrm.storecrm.model.order.Order;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing orders.
 */
public interface OrderService {

    /**
     * Creates a new orderdto.
     *
     * @param order the orderdto to create.
     * @return the created orderdto.
     */
    Order createOrder(Order order);

    /**
     * Retrieves an orderdto by its ID.
     *
     * @param id the ID of the orderdto to retrieve.
     * @return an Optional containing the orderdto if found, or Optional.empty if not.
     */
    Optional<Order> getOrderById(Long id);

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders.
     */
    List<Order> getAllOrders();

    /**
     * Updates an existing orderdto.
     *
     * @param id    the ID of the orderdto to update.
     * @param order the orderdto data to update.
     * @return the updated orderdto, or Optional.empty if the orderdto was not found.
     */
    Optional<Order> updateOrder(Long id, Order order);

    /**
     * Deletes an orderdto by its ID.
     *
     * @param id the ID of the orderdto to delete.
     * @return true if the orderdto was deleted, false otherwise.
     */
    boolean deleteOrder(Long id);
}
