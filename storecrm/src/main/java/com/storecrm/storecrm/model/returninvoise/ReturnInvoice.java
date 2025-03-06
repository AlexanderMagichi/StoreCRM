package com.storecrm.storecrm.model.returninvoise;

import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a returnfromcustomer invoice in the system.
 * This entity stores information about returns from suppliers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "return_invoice")
@Schema(description = "Represents a returnfromcustomer invoice for goods returned to suppliers.")
public class ReturnInvoice {

    /**
     * The unique identifier for the returnfromcustomer invoice.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier of the returnfromcustomer invoice.", example = "1")
    private Long id;

    /**
     * The date of the returnfromcustomer invoice.
     * Automatically set to the current timestamp.
     */
    @NotNull
    @Column(name = "date", nullable = false)
    @Schema(description = "The date of the returnfromcustomer invoice.", example = "2024-10-17")
    private java.sql.Timestamp date;

    /**
     * The supplier associated with this returnfromcustomer invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_return_invoice_supplier"))
    @Schema(description = "The supplier associated with this returnfromcustomer invoice.")
    @ToString.Include(name = "supplier")
    private Supplier supplier;

    /**
     * The total amount for this returnfromcustomer invoice.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "total_amount", nullable = false)
    @Schema(description = "The total amount for the returnfromcustomer invoice.", example = "150.75")
    private BigDecimal totalAmount;

    /**
     * The status of the returnfromcustomer invoice.
     * This is a required field and must be one of the specified values.
     */
    @NotNull
    @Column(name = "status", nullable = false)
    @Schema(description = "The status of the returnfromcustomer invoice.", example = "Pending")
    private String status;

    /**
     * The user who created this returnfromcustomer invoice.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_return_invoice_user"))
    @Schema(description = "The user who created this returnfromcustomer invoice.")
    @ToString.Include(name = "createdBy")
    private User createdBy;

    /**
     * Determines whether two ReturnInvoice objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the returnfromcustomer invoices have the same ID, false otherwise.
     */
    @Override
    @Schema(hidden = true)
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ReturnInvoice returnInvoice)) return false;

        return getId() != null && Objects.equals(getId(), returnInvoice.getId());
    }

    /**
     * Generates a hash code based on the ID of the returnfromcustomer invoice.
     *
     * @return hash code for the returnfromcustomer invoice.
     */
    @Override
    @Schema(hidden = true)
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
