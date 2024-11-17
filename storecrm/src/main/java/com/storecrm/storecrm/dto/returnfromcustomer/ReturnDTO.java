package com.storecrm.storecrm.dto.returnfromcustomer;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReturnDTO {

    private Long id;

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotNull(message = "Product ID cannot be null")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotBlank(message = "Reason cannot be blank")
    private String reason;

    @NotNull(message = "Return date cannot be null")
    private LocalDateTime returnDate;

    private Long purchaseInvoiceId;
}
