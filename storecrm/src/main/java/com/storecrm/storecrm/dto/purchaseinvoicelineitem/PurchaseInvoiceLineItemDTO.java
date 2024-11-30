package com.storecrm.storecrm.dto.purchaseinvoicelineitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Schema(description = "Represents a line item in a purchase invoice.")
public class PurchaseInvoiceLineItemDTO {

    @Schema(description = "The unique identifier for the purchase invoice line item", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Invoice ID cannot be null")
    @Schema(description = "The ID of the related purchase invoice", example = "1")
    private Long invoiceId;

    @NotNull(message = "Product ID cannot be null")
    @Schema(description = "The ID of the product for the line item", example = "1")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Schema(description = "The quantity of the product in the purchase invoice line item", example = "10")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Schema(description = "The price of the product for the line item", example = "100.00")
    private BigDecimal price;

    @NotNull(message = "Total Amount cannot be null")
    @Schema(description = "The total amount for the line item (quantity * price)", example = "1000.00")
    private BigDecimal totalAmount;

    // Add constructor
    public PurchaseInvoiceLineItemDTO(Long id, Long invoiceId, Long productId, Integer quantity, BigDecimal price, BigDecimal totalAmount) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
    }
}
