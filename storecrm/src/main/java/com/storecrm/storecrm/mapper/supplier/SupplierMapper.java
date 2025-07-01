package com.storecrm.storecrm.mapper.supplier;


import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import com.storecrm.storecrm.model.supplier.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    /**
     * Converts a Supplier entity to a SupplierResponse DTO.
     *
     * @param supplier the Supplier entity.
     * @return the SupplierResponse DTO.
     */
    public SupplierDTO.SupplierResponse toResponseDTO(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        }
        return SupplierDTO.SupplierResponse.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .build();
    }

    /**
     * Converts a Create DTO to a Supplier entity.
     *
     * @param createDTO the Create DTO.
     * @return the Supplier entity.
     */
    public Supplier toEntity(SupplierDTO.Create createDTO) {
        if (createDTO == null) {
            throw new IllegalArgumentException("Create DTO cannot be null");
        }
        return Supplier.builder()
                .name(createDTO.getName())
                .address(createDTO.getAddress())
                .email(createDTO.getEmail())
                .phone(createDTO.getPhone())
                .build();
    }
}
