package com.storecrm.storecrm.mapper.supplier;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import com.storecrm.storecrm.model.supplier.Supplier;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting Supplier entity to SupplierDTO and vice versa.
 */
@Component
public class SupplierMapper {

    /**
     * Converts a Supplier entity to a SupplierDTO.
     *
     * @param supplier the Supplier entity.
     * @return the SupplierDTO.
     */
    public SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        }
        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .build();
    }

    /**
     * Converts a SupplierDTO to a Supplier entity.
     *
     * @param supplierDTO the SupplierDTO.
     * @return the Supplier entity.
     */
    public Supplier toEntity(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            throw new IllegalArgumentException("SupplierDTO cannot be null");
        }
        return Supplier.builder()
                .name(supplierDTO.getName())
                .address(supplierDTO.getAddress())
                .email(supplierDTO.getEmail())
                .phone(supplierDTO.getPhone())
                .build();
    }
}
