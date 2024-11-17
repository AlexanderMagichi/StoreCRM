package com.storecrm.storecrm.dto.inventorymovement;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class InventoryMovementDTO {

    private Long id;

    @NotNull(message = "Product ID cannot be null")
    private Long productId;

    @NotNull(message = "Movement date cannot be null")
    private LocalDateTime movementDate;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Movement type cannot be null")
    @Size(min = 3, max = 10, message = "Movement type must be between 3 and 10 characters")
    private String movementType;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @Size(max = 50, message = "Reference type cannot exceed 50 characters")
    private String referenceType;

    private Long referenceId;

    @Size(max = 255, message = "Comment cannot exceed 255 characters")
    private String comment;
}
