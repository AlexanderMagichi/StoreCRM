package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a return of a product from an order.
 * This entity stores information about returns made by customers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "return_item")
public class Return {

    /**
     * The unique identifier for the return.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The ID of the order from which this return is made.
     * This field is required.
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * The ID of the product being returned.
     * This field is required.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    /**
     * The quantity of the product being returned.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The reason for the return.
     * This field is required.
     */
    @NotNull
    @Column(name = "reason", nullable = false)
    private String reason;

    /**
     * The date and time when the return was made.
     * This field is required and is set to the current timestamp by default.
     */
    @NotNull
    @Column(name = "return_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime returnDate;

    /**
     * The ID of the associated purchase invoice.
     * This field is required.
     */
    @NotNull
    @Column(name = "purchase_invoice_id", nullable = false)
    private Long purchaseInvoiceId;

    /**
     * Determines whether two Return objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the returns have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Return aReturn)) return false;

        return getId() != null && Objects.equals(getId(), aReturn.getId());
    }

    /**
     * Generates a hash code based on the ID of the return.
     *
     * @return hash code for the return.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
