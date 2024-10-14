package com.storecrm.storecrm.repository;

import com.storecrm.storecrm.model.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing Purchase Invoice entities.
 * This interface provides methods for performing CRUD operations
 * and custom queries based on supplier ID, invoice number, and
 * invoice date range.
 */
@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

    List<PurchaseInvoice> findBySupplierId(Long supplierId);

    List<PurchaseInvoice> findByInvoiceNumberContainingIgnoreCase(String invoiceNumber);

    List<PurchaseInvoice> findByInvoiceNumber(String invoiceNumber);

    List<PurchaseInvoice> findByInvoiceNumberAndSupplierId(String invoiceNumber, Long supplierId);

    /**
     * Finds Purchase Invoices between the specified start and end dates.
     *
     * @param startDate the start date for the search
     * @param endDate the end date for the search
     * @return a list of Purchase Invoices within the specified date range
     */
    List<PurchaseInvoice> findByInvoiceDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<PurchaseInvoice> findByInvoiceDateBetweenAndSupplierId(LocalDateTime startDate, LocalDateTime endDate, Long supplierId);

    /**
     * Finds Purchase Invoices between the specified start and end dates
     * for a given supplier ID and containing a specific invoice number.
     *
     * @param startDate the start date for the search
     * @param endDate the end date for the search
     * @param supplierId the ID of the supplier
     * @param invoiceNumber the invoice number to search for
     * @return a list of matching Purchase Invoices
     */
    List<PurchaseInvoice> findByInvoiceDateBetweenAndSupplierIdAndInvoiceNumberContainingIgnoreCase(LocalDateTime startDate, LocalDateTime endDate, Long supplierId, String invoiceNumber);
}
