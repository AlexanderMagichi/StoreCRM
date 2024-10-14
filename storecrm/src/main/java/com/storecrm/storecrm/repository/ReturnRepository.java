package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Return} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to returns made by customers.
 */
@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {

    List<Return> findByOrderId(Long orderId);

    List<Return> findByCustomerId(Long customerId);

    List<Return> findByProductId(Long productId);

    List<Return> findByReturnDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Return> findByQuantityBetween(int minQuantity, int maxQuantity);
}
