package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Objects;

/**
 * Represents a return invoice in the system.
 * This entity stores information about returns from suppliers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "return_invoice")
public class ReturnInvoice {

    /**
     * The unique identifier for the return invoice.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The date of the return invoice.
     * Automatically set to the current timestamp.
     */
    @NotNull
    @Column(name = "date", nullable = false)
    private java.sql.Timestamp date;

    /**
     * The supplier associated with this return invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_return_invoice_supplier"))
    @ToString.Include(name = "supplier") // Include supplier in toString()
    private Supplier supplier;

    /**
     * The total amount for this return invoice.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    /**
     * The status of the return invoice.
     * This is a required field and must be one of the specified values.
     */
    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * The user who created this return invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_return_invoice_user"))
    @ToString.Include(name = "createdBy") // Include createdBy in toString()
    private User createdBy;

    /**
     * Determines whether two ReturnInvoice objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the return invoices have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ReturnInvoice returnInvoice)) return false;

        return getId() != null && Objects.equals(getId(), returnInvoice.getId());
    }

    /**
     * Generates a hash code based on the ID of the return invoice.
     *
     * @return hash code for the return invoice.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
