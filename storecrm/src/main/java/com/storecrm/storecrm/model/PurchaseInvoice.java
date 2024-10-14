package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Objects;
import java.util.Set;

/**
 * Represents a purchase invoice in the store's inventory system.
 * This entity stores information about incoming invoices from suppliers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchase_invoice")
public class PurchaseInvoice {

    /**
     * The unique identifier for the purchase invoice.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The date when the invoice was created.
     * This is a required field with a default value of the current timestamp.
     */
    @NotNull
    @Column(name = "date", nullable = false, updatable = false)
    private java.sql.Timestamp date;

    /**
     * The supplier associated with this invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_supplier"))
    @ToString.Include(name = "supplier") // Include supplier in toString()
    private Supplier supplier;

    /**
     * The total amount of the invoice.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    /**
     * The status of the invoice.
     * This field can be 'Pending', 'Completed', or 'Cancelled'.
     */
    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * The user who created this invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_user"))
    @ToString.Include(name = "createdBy") // Include createdBy in toString()
    private User createdBy;

    /**
     * The line items associated with this purchase invoice.
     * This is a one-to-many relationship where one invoice can have multiple line items.
     */
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // Avoid circular reference in toString()
    private Set<PurchaseInvoiceLineItem> lineItems;

    /**
     * Determines whether two PurchaseInvoice objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the invoices have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof PurchaseInvoice purchaseInvoice)) return false;

        return getId() != null && Objects.equals(getId(), purchaseInvoice.getId());
    }

    /**
     * Generates a hash code based on the ID of the purchase invoice.
     *
     * @return hash code for the purchase invoice.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
