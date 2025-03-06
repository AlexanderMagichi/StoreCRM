package com.storecrm.storecrm.service.customer;

import com.storecrm.storecrm.model.customer.Customer;
import com.storecrm.storecrm.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CustomerService interface.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Customer> updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            return customerRepository.save(existingCustomer);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
