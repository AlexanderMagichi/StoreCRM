package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link User} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to users in the system.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsernameContainingIgnoreCase(String username);

    List<User> findByEmailContainingIgnoreCase(String email);

    List<User> findByRoleId(Long roleId);

    List<User> findByActive(boolean active);

    User findByUsername(String username);
}
