package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for managing {@link Product} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries based on product attributes such as
 * article number, name, price, supplier ID, and stock levels.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByArt(String art);

    List<Product> findByArtContainingIgnoreCase(String art);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findBySupplierId(Long supplierId);

    List<Product> findByStockLessThan(int minStock);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
