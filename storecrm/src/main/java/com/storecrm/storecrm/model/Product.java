package com.storecrm.storecrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a product in the store's inventory.
 * This entity is used to store information about products, including their price, stock, and supplier.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {

    /**
     * The unique identifier for the product.
     * Generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The article number (art) of the product, used for uniquely identifying products beyond just the ID.
     * This field is required and must be unique.
     */
    @NotNull
    @Column(name = "art", nullable = false, unique = true)
    private String art;

    /**
     * The name of the product.
     * This is a required field.
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * A detailed description of the product.
     * Can contain more text as it is stored as a Large Object (LOB) in the database.
     */
    @Lob
    @Column(name = "description")
    private String description;

    /**
     * The price of the product.
     * This is a required field.
     */
    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    /**
     * The current stock level of the product.
     * Represents how many items of this product are available.
     */
    @NotNull
    @Column(name = "stock", nullable = false)
    private Integer stock;

    /**
     * The date and time when the product was last updated.
     * Used to track changes in the product's details.
     */
    @NotNull
    @Column(name = "last_updated", nullable = false)
    private String lastUpdated;

    /**
     * The supplier associated with this product.
     * This is a foreign key reference to the Supplier entity.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_supplier"))
    private Supplier supplier;

    /**
     * Determines whether two Product objects are equal based on their ID.
     * Uses pattern matching for instanceof.
     *
     * @param o the other object to compare to.
     * @return true if the products have the same ID, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        // Unpacking Hibernate Proxy
        if (o instanceof HibernateProxy proxy) {
            o = proxy.getHibernateLazyInitializer().getImplementation();
        }

        // Pattern matching
        if (!(o instanceof Product product)) return false;

        return getId() != null && Objects.equals(getId(), product.getId());
    }

    /**
     * Generates a hash code based on the ID of the product.
     *
     * @return hash code for the product.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }

}
