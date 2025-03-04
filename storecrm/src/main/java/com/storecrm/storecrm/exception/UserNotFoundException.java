package com.storecrm.storecrm.exception;

/**
 * Custom exception to be thrown when a user is not found in the system.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
    }
}
