package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Supplier entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries based on supplier attributes such as name, email,
 * phone, and address.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByNameContainingIgnoreCase(String name);

    List<Supplier> findByEmailContainingIgnoreCase(String email);

    List<Supplier> findByPhoneContainingIgnoreCase(String phone);

    List<Supplier> findByAddressContainingIgnoreCase(String address);
}
