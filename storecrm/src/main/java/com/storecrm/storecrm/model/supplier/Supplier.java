package com.storecrm.storecrm.model.supplier;

import com.storecrm.storecrm.model.product.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;
import java.util.Set;

/**
 * Represents a supplier in the store's inventory system.
 * This entity stores information about suppliers, including their contact details.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "supplier")
@Schema(description = "Represents a supplier providing products to the store.")
public class Supplier {

    /**
     * The unique identifier for the supplier.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier of the supplier.", example = "1")
    private Long id;

    /**
     * The name of the supplier.
     * This is a required field.
     */
    @NotNull
    @Column(name = "name", nullable = false)
    @Schema(description = "The name of the supplier.", example = "ABC Supplies Ltd.")
    private String name;

    /**
     * The address of the supplier.
     * This field is optional.
     */
    @Column(name = "address")
    @Schema(description = "The address of the supplier.", example = "123 Market Street, Cityville")
    private String address;

    /**
     * The email of the supplier.
     * This is a required field and must be unique.
     */
    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    @Schema(description = "The email address of the supplier.", example = "supplier@example.com")
    private String email;

    /**
     * The phone number of the supplier.
     * This field is optional.
     */
    @Column(name = "phone")
    @Schema(description = "The phone number of the supplier.", example = "+123456789")
    private String phone;

    /**
     * The products supplied by this supplier.
     * This is a one-to-many relationship where one supplier can supply many products.
     */
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // Avoid circular reference in toString()
    @Schema(description = "The list of products supplied by this supplier.")
    private Set<Product> products;

    /**
     * Determines whether two Supplier objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the suppliers have the same ID, false otherwise.
     */
    @Override
    @Schema(hidden = true)
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Supplier supplier)) return false;

        return getId() != null && Objects.equals(getId(), supplier.getId());
    }

    /**
     * Generates a hash code based on the ID of the supplier.
     *
     * @return hash code for the supplier.
     */
    @Override
    @Schema(hidden = true)
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
