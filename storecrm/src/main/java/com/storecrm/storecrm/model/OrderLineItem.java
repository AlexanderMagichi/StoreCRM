package com.storecrm.storecrm.model;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "order_line_item")
public class OrderLineItem {

    /**
     * The unique identifier for the order line item.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The ID of the order to which this line item belongs.
     * This field is required.
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * The ID of the product associated with this line item.
     * This field is required.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    /**
     * The quantity of the product ordered.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The price of the product at the time of the order.
     * This field is required.
     */
    @NotNull
    @Column(name = "price", nullable = false)
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
