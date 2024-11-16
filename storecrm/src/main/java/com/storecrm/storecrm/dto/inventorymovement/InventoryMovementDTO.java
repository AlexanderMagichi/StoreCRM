package com.storecrm.storecrm.dto.inventorymovement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class InventoryMovementDTO {
    private Long id;
    private Long productId;
    private LocalDateTime movementDate;
    private Integer quantity;
    private String movementType;
    private String description;
    private String referenceType;
    private Long referenceId;
    private String comment;
}
