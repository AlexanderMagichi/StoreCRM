package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Objects;

/**
 * Represents a line item in a purchase invoice.
 * This entity stores information about products associated with a specific purchase invoice.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchase_invoice_line_item")
public class PurchaseInvoiceLineItem {

    /**
     * The unique identifier for the purchase invoice line item.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The purchase invoice associated with this line item.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_line_item_invoice"))
    @ToString.Include(name = "invoice") // Include invoice in toString()
    private PurchaseInvoice invoice;

    /**
     * The product associated with this line item.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_line_item_product"))
    @ToString.Include(name = "product") // Include product in toString()
    private Product product;

    /**
     * The quantity of the product in this line item.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The price of the product in this line item.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "price", nullable = false)
    private Double price;

    /**
     * Determines whether two PurchaseInvoiceLineItem objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the line items have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof PurchaseInvoiceLineItem lineItem)) return false;

        return getId() != null && Objects.equals(getId(), lineItem.getId());
    }

    /**
     * Generates a hash code based on the ID of the purchase invoice line item.
     *
     * @return hash code for the purchase invoice line item.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
