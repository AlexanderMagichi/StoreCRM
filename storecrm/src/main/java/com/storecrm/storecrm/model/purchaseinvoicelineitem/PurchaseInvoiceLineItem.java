package com.storecrm.storecrm.model.purchaseinvoicelineitem;

import com.storecrm.storecrm.model.product.Product;
import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Builder
@ToString
@Entity
@Table(name = "purchase_invoice_line_item")
@Schema(description = "Represents a line item in a purchase invoice, containing product details and quantity.")
public class PurchaseInvoiceLineItem {

    /**
     * The unique identifier for the purchase invoice line item.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier of the purchase invoice line item.", example = "1")
    private Long id;

    /**
     * The purchase invoice associated with this line item.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_line_item_invoice"))
    @ToString.Include(name = "invoice")
    @Schema(description = "The purchase invoice to which this line item belongs.")
    private PurchaseInvoice invoice;

    /**
     * The product associated with this line item.
     * This is a required field.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_invoice_line_item_product"))
    @ToString.Include(name = "product")
    @Schema(description = "The product associated with this line item.")
    private Product product;

    /**
     * The quantity of the product in this line item.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "quantity", nullable = false)
    @Schema(description = "The quantity of the product.", example = "5")
    private Integer quantity;

    /**
     * The unit price of the product in this line item.
     * This is a required field and must be positive.
     */
    @NotNull
    @Positive
    @Column(name = "unit_price", nullable = false)
    @Schema(description = "The unit price of the product in this line item.", example = "15.99")
    private Double unitPrice;

    /**
     * The total amount of this line item (unit price * quantity).
     */
    @Transient
    @Schema(description = "The total amount of the line item (unit price * quantity).", example = "79.95")
    private Double totalAmount;

    /**
     * Calculates the total amount for this line item based on unit price and quantity.
     * This method is used to calculate the totalAmount.
     */
    public Double getTotalAmount() {
        if (unitPrice != null && quantity != null) {
            return unitPrice * quantity;
        }
        return 0.0;
    }

    // Equals and hashCode methods...

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
