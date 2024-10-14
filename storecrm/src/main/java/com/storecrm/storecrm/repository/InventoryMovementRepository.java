package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing {@link InventoryMovement} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to inventory movements in the system.
 */
@Repository
public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, Long> {

    List<InventoryMovement> findByProductId(Long productId);

    List<InventoryMovement> findByMovementType(String movementType);

    List<InventoryMovement> findByQuantityBetween(int minQuantity, int maxQuantity);

    List<InventoryMovement> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<InventoryMovement> findByUserId(Long userId);

}
