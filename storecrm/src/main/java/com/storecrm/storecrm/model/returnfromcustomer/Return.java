package com.storecrm.storecrm.model.returnfromcustomer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a returnfromcustomer of a product from an order.
 * This entity stores information about returns made by customers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "return_item")
@Schema(description = "Represents a returnfromcustomer of a product from an order.")
public class Return {

    /**
     * The unique identifier for the returnfromcustomer.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "Unique identifier of the returnfromcustomer.", example = "1")
    private Long id;

    /**
     * The ID of the order from which this returnfromcustomer is made.
     * This field is required.
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    @Schema(description = "The ID of the order from which this returnfromcustomer is made.", example = "12345")
    private Long orderId;

    /**
     * The ID of the product being returned.
     * This field is required.
     */
    @NotNull
    @Column(name = "product_id", nullable = false)
    @Schema(description = "The ID of the product being returned.", example = "98765")
    private Long productId;

    /**
     * The quantity of the product being returned.
     * This field is required.
     */
    @NotNull
    @Column(name = "quantity", nullable = false)
    @Schema(description = "The quantity of the product being returned.", example = "2")
    private Integer quantity;

    /**
     * The reason for the returnfromcustomer.
     * This field is required.
     */
    @NotNull
    @Column(name = "reason", nullable = false)
    @Schema(description = "The reason for the returnfromcustomer.", example = "Defective item")
    private String reason;

    /**
     * The date and time when the returnfromcustomer was made.
     * This field is required and is set to the current timestamp by default.
     */
    @NotNull
    @Column(name = "return_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Schema(description = "The date and time when the returnfromcustomer was made.", example = "2024-10-15T15:30:00")
    private LocalDateTime returnDate;

    /**
     * The ID of the associated purchase invoice.
     * This field is required.
     */
    @NotNull
    @Column(name = "purchase_invoice_id", nullable = false)
    @Schema(description = "The ID of the associated purchase invoice.", example = "56789")
    private Long purchaseInvoiceId;

    /**
     * Determines whether two Return objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the returns have the same ID, false otherwise.
     */
    @Override
    @Schema(hidden = true)
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Return aReturn)) return false;

        return getId() != null && Objects.equals(getId(), aReturn.getId());
    }

    /**
     * Generates a hash code based on the ID of the returnfromcustomer.
     *
     * @return hash code for the returnfromcustomer.
     */
    @Override
    @Schema(hidden = true)
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
