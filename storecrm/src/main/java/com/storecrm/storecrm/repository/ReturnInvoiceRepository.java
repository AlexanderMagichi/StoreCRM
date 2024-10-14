package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.ReturnInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link ReturnInvoice} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to return invoices.
 */
@Repository
public interface ReturnInvoiceRepository extends JpaRepository<ReturnInvoice, Long> {

    List<ReturnInvoice> findBySupplierId(Long supplierId);

    List<ReturnInvoice> findByProductId(Long productId);

    List<ReturnInvoice> findByQuantityBetween(int minQuantity, int maxQuantity);

    List<ReturnInvoice> findByUnitPriceBetween(double minUnitPrice, double maxUnitPrice);

    List<ReturnInvoice> findByTotalPriceBetween(double minTotalPrice, double maxTotalPrice);

    List<ReturnInvoice> findByDiscountBetween(double minDiscount, double maxDiscount);

    List<ReturnInvoice> findByTaxBetween(double minTax, double maxTax);

    List<ReturnInvoice> findByTotalAmountBetween(double minTotalAmount, double maxTotalAmount);

    List<ReturnInvoice> findByDescriptionContainingIgnoreCase(String description);

    List<ReturnInvoice> findByDescriptionNotContainingIgnoreCase(String description);

    List<ReturnInvoice> findByDescriptionIn(List<String> descriptions);

    List<ReturnInvoice> findByDescriptionNotIn(List<String> descriptions);

    List<ReturnInvoice> findByDescriptionOrderByDescriptionAsc(String description);

    List<ReturnInvoice> findByDescriptionOrderByDescriptionDesc(String description);

    List<ReturnInvoice> findBySupplierIdAndProductId(Long supplierId, Long productId);

    List<ReturnInvoice> findBySupplierIdOrProductId(Long supplierId, Long productId);

    List<ReturnInvoice> findByQuantityGreaterThan(int quantity);
}
