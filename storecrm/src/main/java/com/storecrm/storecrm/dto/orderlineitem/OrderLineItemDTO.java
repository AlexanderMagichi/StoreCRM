package com.storecrm.storecrm.dto.orderlineitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Schema(description = "Represents a line item in an order.")
public class OrderLineItemDTO {

    @Schema(description = "The unique identifier for the order line item", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Order ID cannot be null")
    @Schema(description = "The ID of the order to which this line item belongs", example = "1001")
    private Long orderId;

    @NotNull(message = "Product ID cannot be null")
    @Schema(description = "The ID of the product associated with this line item", example = "2001")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Schema(description = "The quantity of the product in this line item", example = "2")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Schema(description = "The price of a single unit of the product in this line item", example = "25.50")
    private BigDecimal price;
}
