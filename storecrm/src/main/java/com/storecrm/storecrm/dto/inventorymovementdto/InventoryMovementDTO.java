package com.storecrm.storecrm.dto.inventorymovementdto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "DTO for representing inventory movement information")
public class InventoryMovementDTO {

    @Schema(description = "The unique identifier for the inventory movement", example = "1", required = false)
    private Long id;

    @NotNull(message = "Product ID cannot be null")
    @Schema(description = "The ID of the productdto for the movement", example = "101", required = true)
    private Long productId;

    @NotNull(message = "Movement date cannot be null")
    @Schema(description = "The date and time when the inventory movement occurred", example = "2024-11-30T10:00:00", required = true)
    private LocalDateTime movementDate;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Schema(description = "The quantity of the productdto being moved", example = "100", required = true)
    private Integer quantity;

    @NotNull(message = "Movement type cannot be null")
    @Size(min = 3, max = 10, message = "Movement type must be between 3 and 10 characters")
    @Schema(description = "The type of inventory movement (e.g., 'IN', 'OUT', 'RETURN')", example = "IN", required = true)
    private String movementType;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Schema(description = "A detailed description of the inventory movement", example = "Product received from supplierservice", required = false)
    private String description;

    @Size(max = 50, message = "Reference type cannot exceed 50 characters")
    @Schema(description = "The type of reference for the movement (e.g., 'PURCHASE', 'RETURN')", example = "PURCHASE", required = false)
    private String referenceType;

    @Schema(description = "The ID of the reference document related to the movement", example = "1001", required = false)
    private Long referenceId;

    @Size(max = 255, message = "Comment cannot exceed 255 characters")
    @Schema(description = "Any additional comments related to the inventory movement", example = "Urgent stock replenishment", required = false)
    private String comment;
}
