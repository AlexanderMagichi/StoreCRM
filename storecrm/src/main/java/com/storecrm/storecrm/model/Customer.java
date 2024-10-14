package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

/**
 * Represents a customer in the system.
 * This entity stores information about customers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * The unique identifier for the customer.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The name of the customer.
     * This is a required field.
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The email of the customer.
     * This is a required field and must be unique.
     */
    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The phone number of the customer.
     */
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;

    /**
     * The address of the customer.
     */
    @Size(max = 255)
    @Column(name = "address")
    private String address;

    /**
     * Determines whether two Customer objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the customers have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Customer customer)) return false;

        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    /**
     * Generates a hash code based on the ID of the customer.
     *
     * @return hash code for the customer.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
