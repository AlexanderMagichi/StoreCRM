package com.storecrm.storecrm.mapper.customer;

import com.storecrm.storecrm.dto.customer.CustomerDTO;
import com.storecrm.storecrm.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    /**
     * Converts {@link Customer} entity to DTO.
     *
     * @param customer entity to convert
     * @return corresponding DTO
     */
    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());

        return customerDTO;
    }

    /**
     * Converts {@link CustomerDTO} to entity.
     *
     * @param customerDTO DTO to convert
     * @return corresponding entity
     */
    public Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            throw new IllegalArgumentException("CustomerDTO cannot be null");
        }

        Customer customer = Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .address(customerDTO.getAddress())
                .build();

        return customer;
    }
}

