package com.storecrm.storecrm.mapper.returninvoise;

import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class ReturnInvoiceMapper {

    /**
     * Converts {@link ReturnInvoice} entity to DTO.
     *
     * @param returnInvoice entity to convert
     * @return corresponding DTO
     */
    public ReturnInvoiceDTO toDTO(ReturnInvoice returnInvoice) {
        if (returnInvoice == null) {
            throw new IllegalArgumentException("ReturnInvoice cannot be null");
        }

        return new ReturnInvoiceDTO(
                returnInvoice.getId(),
                convertTimestampToLocalDateTime(returnInvoice.getDate()),
                returnInvoice.getSupplier() != null ? returnInvoice.getSupplier().getId() : null, // Get supplier ID
                returnInvoice.getTotalAmount() != null ? BigDecimal.valueOf(returnInvoice.getTotalAmount()) : null, // Convert Double to BigDecimal
                returnInvoice.getStatus(),
                returnInvoice.getCreatedBy() != null ? returnInvoice.getCreatedBy().getId() : null // Get createdBy ID
        );
    }

    /**
     * Converts {@link ReturnInvoiceDTO} to entity.
     *
     * @param returnInvoiceDTO DTO to convert
     * @return corresponding entity
     */
    public ReturnInvoice toEntity(ReturnInvoiceDTO returnInvoiceDTO) {
        if (returnInvoiceDTO == null) {
            throw new IllegalArgumentException("ReturnInvoiceDTO cannot be null");
        }

        ReturnInvoice returnInvoice = ReturnInvoice.builder()
                .id(returnInvoiceDTO.getId())
                .date(convertLocalDateTimeToTimestamp(returnInvoiceDTO.getDate()))
                .totalAmount(returnInvoiceDTO.getTotalAmount() != null ? returnInvoiceDTO.getTotalAmount().doubleValue() : null) // Convert BigDecimal to Double
                .status(returnInvoiceDTO.getStatus())
                .build();

        if (returnInvoiceDTO.getSupplierId() != null) {
            Supplier supplier = new Supplier();
            supplier.setId(returnInvoiceDTO.getSupplierId());
            returnInvoice.setSupplier(supplier);
        }

        if (returnInvoiceDTO.getCreatedBy() != null) {
            User user = new User();
            user.setId(returnInvoiceDTO.getCreatedBy());
            returnInvoice.setCreatedBy(user);
        }

        return returnInvoice;
    }

    // Helper method to convert Timestamp to LocalDateTime
    private LocalDateTime convertTimestampToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    // Helper method to convert LocalDateTime to Timestamp
    private Timestamp convertLocalDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime != null ? Timestamp.valueOf(localDateTime) : null;
    }
}
