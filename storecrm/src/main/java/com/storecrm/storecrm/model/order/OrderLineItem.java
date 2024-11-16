package com.storecrm.storecrm.model.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

/**
 * Represents an item in an order.
 * This entity stores information about products included in customer orders.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "order_line_item")
@Schema(description = "Represents an item in an order, storing information about products included in customer orders.")
public class OrderLineItem {

    /**
     * The unique identifier for the order line item.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier for the order line item", example = "5001", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * The ID of the order to which this line item belongs.
     * This field is required.
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    @Schema(description = "The ID of the order to which this line item belongs", example = "1001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long orderId;

    /**
     * The ID of the product associated with this line item.
     * This field is required.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    @Schema(description = "The ID of the product associated with this line item", example = "3001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long productId;

    /**
     * The quantity of the product ordered.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    @Schema(description = "The quantity of the product ordered", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer quantity;

    /**
     * The price of the product at the time of the order.
     * This field is required.
     */
    @NotNull
    @Column(name = "price", nullable = false)
    @Schema(description = "The price of the product at the time of the order", example = "29.99", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double price;

    /**
     * Determines whether two OrderLineItem objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the order line items have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrderLineItem orderLineItem)) return false;

        return getId() != null && Objects.equals(getId(), orderLineItem.getId());
    }

    /**
     * Generates a hash code based on the ID of the order line item.
     *
     * @return hash code for the order line item.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
