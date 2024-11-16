package com.storecrm.storecrm.model.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

/**
 * Represents an inventory movement in the system.
 * This entity records changes in the inventory for products.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inventory_movement")
@Schema(description = "Represents an inventory movement in the system, recording changes in inventory for products.")
public class InventoryMovement {

    /**
     * The unique identifier for the inventory movement.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier for the inventory movement", example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * The product ID associated with this inventory movement.
     * This field is required and must reference a valid product.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    @Schema(description = "The product ID associated with this inventory movement", example = "2001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long productId;

    /**
     * The date of the inventory movement.
     * Defaults to the current timestamp when the record is created.
     */
    @NotNull
    @Column(name = "movement_date", nullable = false)
    @Schema(description = "The date of the inventory movement", example = "2024-10-15T12:30:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private java.sql.Timestamp movementDate;

    /**
     * The quantity involved in the inventory movement.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    @Schema(description = "The quantity involved in the inventory movement", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer quantity;

    /**
     * The type of movement (e.g., ARRIVAL, SALE, RETURN).
     * This field is required and should be one of the defined types.
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "movement_type", nullable = false)
    @Schema(description = "The type of movement (e.g., ARRIVAL, SALE, RETURN)", example = "ARRIVAL", requiredMode = Schema.RequiredMode.REQUIRED)
    private String movementType;

    /**
     * A description of the inventory movement.
     * This field is optional.
     */
    @Size(max = 255)
    @Column(name = "description")
    @Schema(description = "A description of the inventory movement", example = "Arrival of 50 units of product")
    private String description;

    /**
     * The type of reference for this movement (e.g., PurchaseInvoice, ReturnInvoice).
     * This field is required and should be one of the defined types.
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "reference_type", nullable = false)
    @Schema(description = "The type of reference for this movement (e.g., PurchaseInvoice, ReturnInvoice)", example = "PurchaseInvoice", requiredMode = Schema.RequiredMode.REQUIRED)
    private String referenceType;

    /**
     * The ID of the referenced entity (e.g., the invoice or order associated with the movement).
     * This field is optional.
     */
    @Column(name = "reference_id")
    @Schema(description = "The ID of the referenced entity (e.g., invoice or order)", example = "3001")
    private Long referenceId;

    /**
     * Any additional comments related to the inventory movement.
     * This field is optional.
     */
    @Size(max = 255)
    @Column(name = "comment")
    @Schema(description = "Any additional comments related to the inventory movement", example = "Initial stock adjustment")
    private String comment;

    /**
     * Determines whether two InventoryMovement objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the inventory movements have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof InventoryMovement inventoryMovement)) return false;

        return getId() != null && Objects.equals(getId(), inventoryMovement.getId());
    }

    /**
     * Generates a hash code based on the ID of the inventory movement.
     *
     * @return hash code for the inventory movement.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
