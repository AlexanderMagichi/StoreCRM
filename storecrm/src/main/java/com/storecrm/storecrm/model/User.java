package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

/**
 * Represents a user in the system.
 * This entity stores information about users who can access the system.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {

    /**
     * The unique identifier for the user.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The username of the user.
     * This field is required and must be unique.
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * The hashed password of the user.
     * This field is required.
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    /**
     * The role ID associated with the user.
     * This field is required.
     */
    @NotNull
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    /**
     * Determines whether two User objects are equal based on their ID.
     *
     * @param o the other object to compare to.
     * @return true if the users have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof User user)) return false;

        return getId() != null && Objects.equals(getId(), user.getId());
    }

    /**
     * Generates a hash code based on the ID of the user.
     *
     * @return hash code for the user.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
