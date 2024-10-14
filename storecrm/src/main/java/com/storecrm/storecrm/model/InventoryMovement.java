package com.storecrm.storecrm.model;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inventory_movement")
public class InventoryMovement {

    /**
     * The unique identifier for the inventory movement.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The product ID associated with this inventory movement.
     * This field is required and must reference a valid product.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    /**
     * The date of the inventory movement.
     * Defaults to the current timestamp when the record is created.
     */
    @NotNull
    @Column(name = "movement_date", nullable = false)
    private java.sql.Timestamp movementDate;

    /**
     * The quantity involved in the inventory movement.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The type of movement (e.g., ARRIVAL, SALE, RETURN).
     * This field is required and should be one of the defined types.
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "movement_type", nullable = false)
    private String movementType;

    /**
     * A description of the inventory movement.
     * This field is optional.
     */
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    /**
     * The type of reference for this movement (e.g., PurchaseInvoice, ReturnInvoice).
     * This field is required and should be one of the defined types.
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "reference_type", nullable = false)
    private String referenceType;

    /**
     * The ID of the referenced entity (e.g., the invoice or order associated with the movement).
     * This field is optional.
     */
    @Column(name = "reference_id")
    private Long referenceId;

    /**
     * Any additional comments related to the inventory movement.
     * This field is optional.
     */
    @Size(max = 255)
    @Column(name = "comment")
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
