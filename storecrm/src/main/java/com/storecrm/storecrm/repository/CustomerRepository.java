package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Customer} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to customers.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByNameContainingIgnoreCase(String name);

    List<Customer> findByEmailContainingIgnoreCase(String email);

    List<Customer> findByPhoneContainingIgnoreCase(String phone);

    List<Customer> findByAddressContainingIgnoreCase(String address);

    List<Customer> findByLastNameContainingIgnoreCase(String lastName);
}
