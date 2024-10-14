package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.PurchaseInvoiceLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link PurchaseInvoiceLineItem} entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries related to line items in purchase invoices.
 */
@Repository
public interface PurchaseInvoiceLineItemRepository extends JpaRepository<PurchaseInvoiceLineItem, Long> {

    List<PurchaseInvoiceLineItem> findByPurchaseInvoiceId(Long purchaseInvoiceId);

    List<PurchaseInvoiceLineItem> findByProductId(Long productId);

    List<PurchaseInvoiceLineItem> findByQuantityBetween(int minQuantity, int maxQuantity);

    List<PurchaseInvoiceLineItem> findByUnitPriceBetween(double minUnitPrice, double maxUnitPrice);

    List<PurchaseInvoiceLineItem> findByTotalPriceBetween(double minTotalPrice, double maxTotalPrice);

    List<PurchaseInvoiceLineItem> findByDiscountBetween(double minDiscount, double maxDiscount);

    List<PurchaseInvoiceLineItem> findByTaxBetween(double minTax, double maxTax);

    List<PurchaseInvoiceLineItem> findByTotalAmountBetween(double minTotalAmount, double maxTotalAmount);

    List<PurchaseInvoiceLineItem> findByDescriptionContainingIgnoreCase(String description);

    List<PurchaseInvoiceLineItem> findByDescriptionNotContainingIgnoreCase(String description);

    List<PurchaseInvoiceLineItem> findByDescriptionIn(List<String> descriptions);

    List<PurchaseInvoiceLineItem> findByDescriptionNotIn(List<String> descriptions);

    List<PurchaseInvoiceLineItem> findByDescriptionOrderByDescriptionAsc(String description);

    List<PurchaseInvoiceLineItem> findByDescriptionOrderByDescriptionDesc(String description);
}
