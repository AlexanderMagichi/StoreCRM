package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link OrderLineItem} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to line items in customer orders.
 */
@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

    List<OrderLineItem> findByOrderId(Long orderId);

    List<OrderLineItem> findByProductId(Long productId);

    List<OrderLineItem> findByQuantityBetween(int minQuantity, int maxQuantity);

    List<OrderLineItem> findByUnitPriceBetween(double minUnitPrice, double maxUnitPrice);

    List<OrderLineItem> findByTotalPriceBetween(double minTotalPrice, double maxTotalPrice);
}
