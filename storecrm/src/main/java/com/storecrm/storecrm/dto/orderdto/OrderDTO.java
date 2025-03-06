package com.storecrm.storecrm.dto.orderdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Represents an orderdto placed by a customerservice in the system.")
public class OrderDTO {

    @Schema(description = "The unique identifier for the orderdto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Date cannot be null")
    @Schema(description = "The date when the orderdto was placed", example = "2024-11-30T10:00:00")
    private LocalDateTime date;

    @NotNull(message = "Customer ID cannot be null")
    @Schema(description = "The ID of the customerservice who placed the orderdto", example = "1")
    private Long customerId;

    @NotNull(message = "Status cannot be null")
    @Size(min = 3, max = 20, message = "Status must be between 3 and 20 characters")
    @Schema(description = "The status of the orderdto", example = "Pending")
    private String status;

    @NotNull(message = "Total amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    @Schema(description = "The total amount of the orderdto", example = "150.75")
    private BigDecimal totalAmount;
}
