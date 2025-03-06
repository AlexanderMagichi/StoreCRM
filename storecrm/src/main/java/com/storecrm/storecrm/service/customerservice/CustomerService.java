package com.storecrm.storecrm.service.customerservice;

import com.storecrm.storecrm.model.customer.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Interface for managing customers.
 */
public interface CustomerService {

    /**
     * Retrieves all customers from the database.
     *
     * @return a list of all customers.
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieves a customerservice by their unique ID.
     *
     * @param id the ID of the customerservice to retrieve.
     * @return an Optional containing the customerservice if found, or Optional.empty() otherwise.
     */
    Optional<Customer> getCustomerById(Long id);

    /**
     * Creates a new customerservice in the database.
     *
     * @param customer the customerservice to create.
     * @return the created customerservice.
     */
    Customer createCustomer(Customer customer);

    /**
     * Updates an existing customerservice in the database.
     *
     * @param id the ID of the customerservice to update.
     * @param updatedCustomer the updated customerservice details.
     * @return an Optional containing the updated customerservice if the update was successful, or Optional.empty() if the customerservice was not found.
     */
    Optional<Customer> updateCustomer(Long id, Customer updatedCustomer);

    /**
     * Deletes a customerservice from the database by their ID.
     *
     * @param id the ID of the customerservice to delete.
     * @return true if the customerservice was deleted, or false if the customerservice was not found.
     */
    boolean deleteCustomer(Long id);
}
