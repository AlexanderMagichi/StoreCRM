package com.storecrm.storecrm.model.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Represents an order in the system.
 * This entity stores information about customer orders.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "order")
@Schema(description = "Represents an order in the system, storing information about customer orders.")
public class Order {

    /**
     * The unique identifier for the order.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier for the order", example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * The date when the order was created.
     * This field is set automatically by the database.
     */
    @NotNull
    @Column(name = "date", nullable = false)
    @Schema(description = "The date when the order was created", example = "2024-10-15T12:30:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private Timestamp date;

    /**
     * The ID of the customer who placed the order.
     * This field is required.
     */
    @NotNull
    @Column(name = "customer_id", nullable = false)
    @Schema(description = "The ID of the customer who placed the order", example = "2001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long customerId;

    /**
     * The current status of the order.
     * This field is required and has specific allowed values.
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "status", nullable = false)
    @Schema(description = "The current status of the order", example = "PENDING", requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;

    /**
     * The total amount for the order.
     * This field is required.
     */
    @NotNull
    @Column(name = "total_amount", nullable = false)
    @Schema(description = "The total amount for the order", example = "150.75", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double totalAmount;

    /**
     * Determines whether two order objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the orders have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Order order)) return false;

        return getId() != null && Objects.equals(getId(), order.getId());
    }

    /**
     * Generates a hash code based on the ID of the order.
     *
     * @return hash code for the order.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
