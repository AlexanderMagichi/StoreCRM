package com.storecrm.storecrm.service.customer;

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
     * Retrieves a customer by their unique ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return an Optional containing the customer if found, or Optional.empty() otherwise.
     */
    Optional<Customer> getCustomerById(Long id);

    /**
     * Creates a new customer in the database.
     *
     * @param customer the customer to create.
     * @return the created customer.
     */
    Customer createCustomer(Customer customer);

    /**
     * Updates an existing customer in the database.
     *
     * @param id the ID of the customer to update.
     * @param updatedCustomer the updated customer details.
     * @return an Optional containing the updated customer if the update was successful, or Optional.empty() if the customer was not found.
     */
    Optional<Customer> updateCustomer(Long id, Customer updatedCustomer);

    /**
     * Deletes a customer from the database by their ID.
     *
     * @param id the ID of the customer to delete.
     * @return true if the customer was deleted, or false if the customer was not found.
     */
    boolean deleteCustomer(Long id);
}
