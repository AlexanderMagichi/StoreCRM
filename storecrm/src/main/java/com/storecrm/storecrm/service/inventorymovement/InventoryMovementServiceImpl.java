package com.storecrm.storecrm.service.inventorymovement;

import com.storecrm.storecrm.exception.InventoryMovementNotFoundException;
import com.storecrm.storecrm.model.inventorymovement.InventoryMovement;
import com.storecrm.storecrm.repository.inventorymovement.InventoryMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of InventoryMovementService interface.
 * Provides business logic for inventory movements.
 */
@Service
public class InventoryMovementServiceImpl implements InventoryMovementService {

    private final InventoryMovementRepository inventoryMovementRepository;

    @Autowired
    public InventoryMovementServiceImpl(InventoryMovementRepository inventoryMovementRepository) {
        this.inventoryMovementRepository = inventoryMovementRepository;
    }

    @Override
    public List<InventoryMovement> getAllMovements() {
        return inventoryMovementRepository.findAll();
    }

    @Override
    public Optional<InventoryMovement> getMovementById(Long id) {
        return inventoryMovementRepository.findById(id);
    }

    @Override
    public InventoryMovement createMovement(InventoryMovement movement) {
        return inventoryMovementRepository.save(movement);
    }

    @Override
    public InventoryMovement updateMovement(Long id, InventoryMovement movement) {
        if (!inventoryMovementRepository.existsById(id)) {
            throw new InventoryMovementNotFoundException("Inventory movement not found with id: " + id);

        }
        movement.setId(id);
        return inventoryMovementRepository.save(movement);
    }

    @Override
    public void deleteMovement(Long id) {
        inventoryMovementRepository.deleteById(id);
    }
}
