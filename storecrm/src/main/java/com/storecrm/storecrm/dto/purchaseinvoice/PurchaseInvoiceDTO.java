package com.storecrm.storecrm.dto.purchaseinvoice;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for managing purchase invoices in the system.
 */
public class PurchaseInvoiceDTO {

    /**
     * DTO for creating a new purchase invoice.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "DTO for creating a new purchase invoice.")
    public static class Create {

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
        @Schema(description = "The status of the purchase invoice", example = "Pending")
        private String status;
    }

    /**
     * DTO for updating an existing purchase invoice.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "DTO for updating an existing purchase invoice.")
    public static class Update {

        @NotNull(message = "Date cannot be null")
        @Schema(description = "The date of the purchase invoice", example = "2024-11-30T12:34:56")
        private LocalDateTime date;

        @Schema(description = "The status of the purchase invoice", example = "Completed")
        private String status;

        @Schema(description = "The total amount of the purchase invoice", example = "1500.00")
        private BigDecimal totalAmount;
    }

    /**
     * DTO for responding with purchase invoice details.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "DTO for responding with purchase invoice details.")
    public static class InvoiceResponse {

        @Schema(description = "The unique identifier of the purchase invoice", example = "1")
        private Long id;

        @Schema(description = "The date of the purchase invoice", example = "2024-11-30T12:34:56")
        private LocalDateTime date;

        @Schema(description = "The ID of the supplier for the purchase invoice", example = "1")
        private Long supplierId;

        @Schema(description = "The total amount of the purchase invoice", example = "1500.00")
        private BigDecimal totalAmount;

        @Schema(description = "The status of the purchase invoice", example = "Completed")
        private String status;
    }
}
