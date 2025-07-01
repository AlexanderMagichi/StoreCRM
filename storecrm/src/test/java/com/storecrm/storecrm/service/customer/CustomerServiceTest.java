package com.storecrm.storecrm.service.customer;

import com.storecrm.storecrm.model.customer.Customer;
import com.storecrm.storecrm.repository.customer.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

//    @InjectMocks
//    private CustomerService customerService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        // Arrange
        Customer customer1 = new Customer(1L, "John Doe", "john@example.com", "123456789",
                "123 Street");
        Customer customer2 = new Customer(2L, "Jane Smith", "jane@example.com", "987654321",
                "456 Avenue");
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        List<Customer> customers = customerService.getAllCustomers();

        // Assert
        assertNotNull(customers);
        assertEquals(2, customers.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById_Found() {
        // Arrange
        Customer customer = new Customer(1L, "John Doe", "john@example.com", "123456789",
                "123 Street");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        // Act
        Optional<Customer> result = customerService.getCustomerById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCustomerById_NotFound() {
        // Arrange
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Customer> result = customerService.getCustomerById(1L);

        // Assert
        assertFalse(result.isPresent());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateCustomer() {
        // Arrange
        Customer customer = new Customer(null, "John Doe", "john@example.com", "123456789",
                "123 Street");
        when(customerRepository.save(customer)).thenReturn(new Customer(1L, "John Doe",
                "john@example.com", "123456789", "123 Street"));

        // Act
        Customer createdCustomer = customerService.createCustomer(customer);

        // Assert
        assertNotNull(createdCustomer);
        assertEquals(1L, createdCustomer.getId());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testUpdateCustomer_Found() {
        // Arrange
        Customer existingCustomer = new Customer(1L, "John Doe", "john@example.com", "123456789",
                "123 Street");
        Customer updatedCustomer = new Customer(null, "John Smith", "john.smith@example.com",
                "987654321", "456 Avenue");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Act
        Optional<Customer> result = customerService.updateCustomer(1L, updatedCustomer);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("John Smith", result.get().getName());
        assertEquals("john.smith@example.com", result.get().getEmail());
        verify(customerRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).save(existingCustomer);
    }

    @Test
    void testUpdateCustomer_NotFound() {
        // Arrange
        Customer updatedCustomer = new Customer(null, "John Smith", "john.smith@example.com",
                "987654321", "456 Avenue");
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Customer> result = customerService.updateCustomer(1L, updatedCustomer);

        // Assert
        assertFalse(result.isPresent());
        verify(customerRepository, times(1)).findById(1L);
        verify(customerRepository, times(0)).save(any());
    }

    @Test
    void testDeleteCustomer_Found() {
        // Arrange
        when(customerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(customerRepository).deleteById(1L);

        // Act
        boolean result = customerService.deleteCustomer(1L);

        // Assert
        assertTrue(result);
        verify(customerRepository, times(1)).existsById(1L);
        verify(customerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteCustomer_NotFound() {
        // Arrange
        when(customerRepository.existsById(1L)).thenReturn(false);

        // Act
        boolean result = customerService.deleteCustomer(1L);

        // Assert
        assertFalse(result);
        verify(customerRepository, times(1)).existsById(1L);
        verify(customerRepository, times(0)).deleteById(anyLong());
    }
}
