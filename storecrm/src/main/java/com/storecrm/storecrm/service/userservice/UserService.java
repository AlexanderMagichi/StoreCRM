package com.storecrm.storecrm.service.userservice;

import com.storecrm.storecrm.model.user.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing users in the system.
 */
public interface UserService {

    /**
     * Retrieves all users in the system.
     *
     * @return a list of all users.
     */
    List<User> getAllUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param id the unique identifier of the user.
     * @return an Optional containing the user if found, or empty if not.
     */
    Optional<User> getUserById(Long id);

    /**
     * Creates a new user in the system.
     *
     * @param user the user to be created.
     * @return the created user.
     */
    User createUser(User user);

    /**
     * Updates an existing user in the system.
     *
     * @param id   the unique identifier of the user to update.
     * @param user the user object containing updated information.
     * @return the updated user.
     */
    User updateUser(Long id, User user);

    /**
     * Deletes a user from the system.
     *
     * @param id the unique identifier of the user to delete.
     */
    void deleteUser(Long id);
}
