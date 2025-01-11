package com.storecrm.storecrm.dto.purchaseinvoice;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represents a purchase invoice in the system.")
public class PurchaseInvoiceDTO {

    @Schema(description = "The unique identifier for the purchase invoice", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Date cannot be null")
    @Schema(description = "The date of the purchase invoice", example = "2024-11-30T12:34:56")
    private LocalDateTime date;

    @NotNull(message = "Supplier ID cannot be null")
    @Schema(description = "The ID of the supplier for the purchase invoice", example = "1")
    private Long supplierId;

    @NotNull(message = "Total amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    @Schema(description = "The total amount of the purchase invoice", example = "1500.00")
    private BigDecimal totalAmount;

    @NotBlank(message = "Status cannot be blank")
    @Size(max = 50, message = "Status cannot exceed 50 characters")
    @Schema(description = "The status of the purchase invoice", example = "Paid")
    private String status;

    @NotNull(message = "Created by cannot be null")
    @Schema(description = "The ID of the user who created the purchase invoice", example = "1")
    private Long createdBy;

    /**
     * DTO for creating a purchase invoice.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        @NotNull(message = "Date cannot be null")
        private LocalDateTime date;

        @NotNull(message = "Supplier ID cannot be null")
        private Long supplierId;

        @NotNull(message = "Total amount cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
        private BigDecimal totalAmount;

        @NotBlank(message = "Status cannot be blank")
        @Size(max = 50, message = "Status cannot exceed 50 characters")
        private String status;

        @NotNull(message = "Created by cannot be null")
        private Long createdBy;
    }

    /**
     * DTO for updating a purchase invoice.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        @NotNull(message = "Date cannot be null")
        private LocalDateTime date;

        @NotNull(message = "Supplier ID cannot be null")
        private Long supplierId;

        @NotNull(message = "Total amount cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
        private BigDecimal totalAmount;

        @NotBlank(message = "Status cannot be blank")
        @Size(max = 50, message = "Status cannot exceed 50 characters")
        private String status;

        @NotNull(message = "Created by cannot be null")
        private Long createdBy;
    }
}
