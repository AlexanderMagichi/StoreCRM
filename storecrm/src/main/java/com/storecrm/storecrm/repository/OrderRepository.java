package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing {@link Order} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to customer orders.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Order> findByStatus(String status);

    List<Order> findByTotalAmountBetween(double minTotalAmount, double maxTotalAmount);

    List<Order> findByProductId(Long productId);
}
