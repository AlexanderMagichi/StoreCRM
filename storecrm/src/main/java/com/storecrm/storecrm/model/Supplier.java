package com.storecrm.storecrm.model;

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
@ToString
@Entity
@Table(name = "supplier")
public class Supplier {

    /**
     * The unique identifier for the supplier.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The name of the supplier.
     * This is a required field.
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The address of the supplier.
     * This field is optional.
     */
    @Column(name = "address")
    private String address;

    /**
     * The email of the supplier.
     * This is a required field and must be unique.
     */
    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The phone number of the supplier.
     * This field is optional.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * The products supplied by this supplier.
     * This is a one-to-many relationship where one supplier can supply many products.
     */
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // Avoid circular reference in toString()
    private Set<Product> products;

    /**
     * Determines whether two Supplier objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the suppliers have the same ID, false otherwise.
     */
    @Override
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
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
