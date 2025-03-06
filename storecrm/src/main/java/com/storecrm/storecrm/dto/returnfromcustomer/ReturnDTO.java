package com.storecrm.storecrm.dto.returnfromcustomer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Represents a return from a customerservice.")
public class ReturnDTO {

    @Schema(description = "The unique identifier for the return", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Order ID cannot be null")
    @Schema(description = "The ID of the related orderdto", example = "1")
    private Long orderId;

    @NotNull(message = "Product ID cannot be null")
    @Schema(description = "The ID of the returned productdto", example = "1")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Schema(description = "The quantity of the productdto being returned", example = "2")
    private Integer quantity;

    @NotBlank(message = "Reason cannot be blank")
    @Schema(description = "The reason for the return", example = "Product defective")
    private String reason;

    @NotNull(message = "Return date cannot be null")
    @Schema(description = "The date when the return is processed", example = "2024-11-30T14:30:00")
    private LocalDateTime returnDate;

    @Schema(description = "The ID of the associated purchase invoice, if available", example = "1")
    private Long purchaseInvoiceId;
}
