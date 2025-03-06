package com.storecrm.storecrm.service.inventorymovement;

import com.storecrm.storecrm.model.inventorymovement.InventoryMovement;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing inventory movements.
 */
public interface InventoryMovementService {

    /**
     * Retrieves all inventory movements.
     * @return a list of all inventory movements
     */
    List<InventoryMovement> getAllMovements();

    /**
     * Retrieves a specific inventory movement by ID.
     * @param id the ID of the movement
     * @return an Optional containing the found movement or empty if not found
     */
    Optional<InventoryMovement> getMovementById(Long id);

    /**
     * Creates a new inventory movement.
     * @param movement the movement to create
     * @return the created inventory movement
     */
    InventoryMovement createMovement(InventoryMovement movement);

    /**
     * Updates an existing inventory movement.
     * @param id the ID of the movement to update
     * @param movement the updated movement details
     * @return the updated inventory movement
     */
    InventoryMovement updateMovement(Long id, InventoryMovement movement);

    /**
     * Deletes an inventory movement by ID.
     * @param id the ID of the movement to delete
     */
    void deleteMovement(Long id);
}
