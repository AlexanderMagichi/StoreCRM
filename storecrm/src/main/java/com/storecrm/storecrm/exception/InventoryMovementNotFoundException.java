package com.storecrm.storecrm.exception;

/**
 * Exception thrown when an inventory movement is not found.
 */
public class InventoryMovementNotFoundException extends RuntimeException {

    /**
     * Constructs a new InventoryMovementNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public InventoryMovementNotFoundException(String message) {
        super(message);
    }
}
