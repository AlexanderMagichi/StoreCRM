package com.storecrm.storecrm.dto.returninvoice;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Represents a return invoice in the system.")
public class ReturnInvoiceDTO {

    @Schema(description = "The unique identifier for the return invoice", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Date cannot be null")
    @Schema(description = "The date the return invoice was created", example = "2024-11-30T14:30:00")
    private LocalDateTime date;

    @NotNull(message = "Supplier ID cannot be null")
    @Schema(description = "The ID of the related supplier", example = "1")
    private Long supplierId;

    @NotNull(message = "Total amount cannot be null")
    @Positive(message = "Total amount must be positive")
    @Schema(description = "The total amount of the return invoice", example = "100.50")
    private BigDecimal totalAmount;

    @NotNull(message = "Status cannot be null")
    @Size(min = 3, max = 20, message = "Status must be between 3 and 20 characters")
    @Schema(description = "The status of the return invoice", example = "Processed")
    private String status;

    @NotNull(message = "Created by cannot be null")
    @Schema(description = "The ID of the user who created the return invoice", example = "1")
    private Long createdBy;

    // Constructor with parameters
    public ReturnInvoiceDTO(Long id, LocalDateTime date, Long supplierId, BigDecimal totalAmount, String status, Long createdBy) {
        this.id = id;
        this.date = date;
        this.supplierId = supplierId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdBy = createdBy;
    }
}
