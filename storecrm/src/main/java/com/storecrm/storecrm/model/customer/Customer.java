package com.storecrm.storecrm.model.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;


/**
 * Represents a customerservice in the system.
 * This entity stores information about customers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "customerservice")
@Schema(description = "Represents a customerservice in the system.")
public class Customer {

    /**
     * The unique identifier for the customerservice.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(description = "The unique identifier for the customerservice", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * The name of the customerservice.
     * This is a required field.
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    @Schema(description = "The name of the customerservice", example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * The email of the customerservice.
     * This is a required field and must be unique.
     */
    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    @Schema(description = "The email address of the customerservice. Must be unique.", example = "john.doe@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    /**
     * The phone number of the customerservice.
     */
    @Size(max = 20)
    @Column(name = "phone")
    @Schema(description = "The phone number of the customerservice", example = "+1234567890")
    private String phone;

    /**
     * The address of the customerservice.
     */
    @Size(max = 255)
    @Column(name = "address")
    @Schema(description = "The address of the customerservice", example = "123 Main St, Springfield")
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
     * Generates a hash code based on the ID of the customerservice.
     *
     * @return hash code for the customerservice.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
