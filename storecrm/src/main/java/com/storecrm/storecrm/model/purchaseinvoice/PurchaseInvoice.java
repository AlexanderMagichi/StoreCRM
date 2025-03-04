package com.storecrm.storecrm.model.purchaseinvoice;

import com.storecrm.storecrm.model.purchaseinvoicelineitem.PurchaseInvoiceLineItem;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Builder
@ToString
@Entity
@Table(name = "purchase_invoice")
@Schema(description = "Represents a purchase invoice in the store's inventory system, storing information about incoming invoices from suppliers.")
public class PurchaseInvoice {

    /**
     * The unique identifier for the purchase invoice.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier for the purchase invoice", example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * The date when the invoice was created.
     * This is a required field with a default value of the current timestamp.
     */
    @NotNull
    @Column(name = "date", nullable = false, updatable = false)
    @Schema(description = "The date when the invoice was created", example = "2024-10-15 10:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private java.sql.Timestamp date;

    /**
     * The supplierservice associated with this invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_supplier"))
    @ToString.Include(name = "supplierservice")
    @Schema(description = "The supplierservice associated with this purchase invoice", requiredMode = Schema.RequiredMode.REQUIRED)
    private Supplier supplier;

    /**
     * The total amount of the invoice.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "total_amount", nullable = false)
    @Schema(description = "The total amount of the purchase invoice", example = "1500.75", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double totalAmount;

    /**
     * The status of the invoice.
     * This field can be 'Pending', 'Completed', or 'Cancelled'.
     */
    @NotNull
    @Column(name = "status", nullable = false)
    @Schema(description = "The status of the invoice", example = "Completed", requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;

    /**
     * The user who created this invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_user"))
    @ToString.Include(name = "createdBy")
    @Schema(description = "The user who created this purchase invoice", requiredMode = Schema.RequiredMode.REQUIRED)
    private User createdBy;

    /**
     * The line items associated with this purchase invoice.
     * This is a one-to-many relationship where one invoice can have multiple line items.
     */
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Schema(description = "The line items associated with this purchase invoice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
