package com.storecrm.storecrm.mapper.purchaseinvoice;

import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO;
import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * A utility class responsible for mapping between {@link PurchaseInvoice} and {@link PurchaseInvoiceDTO}.
 * This class provides methods to convert a PurchaseInvoice entity to a PurchaseInvoiceDTO and vice versa.
 */
@Component
public class PurchaseInvoiceMapper {

    /**
     * Converts a {@link PurchaseInvoice} entity to a {@link PurchaseInvoiceDTO}.
     *
     * @param purchaseInvoice the PurchaseInvoice entity to be converted
     * @return the corresponding PurchaseInvoiceDTO
     * @throws IllegalArgumentException if the provided PurchaseInvoice is null
     */
    public PurchaseInvoiceDTO toDTO(PurchaseInvoice purchaseInvoice) {
        if (purchaseInvoice == null) {
            throw new IllegalArgumentException("PurchaseInvoice cannot be null");
        }

        // Convert Timestamp to LocalDateTime
        LocalDateTime localDateTime = purchaseInvoice.getDate().toLocalDateTime();

        return new PurchaseInvoiceDTO(
                purchaseInvoice.getId(),
                localDateTime,
                purchaseInvoice.getSupplier() != null ? purchaseInvoice.getSupplier().getId() : null,
                purchaseInvoice.getTotalAmount() != null ? BigDecimal.valueOf(purchaseInvoice.getTotalAmount()) : null,
                purchaseInvoice.getStatus(),
                purchaseInvoice.getCreatedBy() != null ? purchaseInvoice.getCreatedBy().getId() : null
        );
    }

    /**
     * Converts a {@link PurchaseInvoiceDTO} to a {@link PurchaseInvoice} entity.
     *
     * @param purchaseInvoiceDTO the PurchaseInvoiceDTO to be converted
     * @return the corresponding PurchaseInvoice entity
     * @throws IllegalArgumentException if the provided PurchaseInvoiceDTO is null
     */
    public PurchaseInvoice toEntity(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        if (purchaseInvoiceDTO == null) {
            throw new IllegalArgumentException("PurchaseInvoiceDTO cannot be null");
        }

        // Convert LocalDateTime to Timestamp
        Timestamp timestamp = Timestamp.valueOf(purchaseInvoiceDTO.getDate());

        // Create and populate PurchaseInvoice entity
        PurchaseInvoice purchaseInvoice = PurchaseInvoice.builder()
                .id(purchaseInvoiceDTO.getId())
                .date(timestamp)
                .totalAmount(purchaseInvoiceDTO.getTotalAmount().doubleValue())  // Convert BigDecimal to Double
                .status(purchaseInvoiceDTO.getStatus())
                .build();

        // Create Supplier entity and set the supplierservice ID
        Supplier supplier = new Supplier();
        supplier.setId(purchaseInvoiceDTO.getSupplierId());
        purchaseInvoice.setSupplier(supplier);

        // Create User entity and set the user ID
        User user = new User();
        user.setId(purchaseInvoiceDTO.getCreatedBy());  // Set createdBy ID for User
        purchaseInvoice.setCreatedBy(user);

        return purchaseInvoice;
    }
}
