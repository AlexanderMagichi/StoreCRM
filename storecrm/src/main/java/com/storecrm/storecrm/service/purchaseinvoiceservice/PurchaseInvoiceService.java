package com.storecrm.storecrm.service.purchaseinvoiceservice;

import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Service interface for managing purchase invoices.
 */
@Validated
public interface PurchaseInvoiceService {

    /**
     * Retrieves all purchase invoices.
     *
     * @return a list of InvoiceResponse DTOs representing all purchase invoices.
     */
//    List<PurchaseInvoiceDTO.InvoiceResponse> getAllInvoices();
        List<PurchaseInvoiceDTO.InvoiceR>
    /**
     * Retrieves a specific purchase invoice by its ID.
     *
     * @param id the ID of the purchase invoice to retrieve.
     * @return an InvoiceResponse DTO representing the requested purchase invoice.
     * @throws jakarta.persistence.EntityNotFoundException if no invoice is found with the given ID.
     */
    PurchaseInvoiceDTO.InvoiceResponse getInvoiceById(Long id);

    /**
     * Creates a new purchase invoice.
     *
     * @param invoiceDTO the data for the new purchase invoice.
     * @return an InvoiceResponse DTO representing the created purchase invoice.
     */
    PurchaseInvoiceDTO.InvoiceResponse createInvoice(@Valid PurchaseInvoiceDTO.Create invoiceDTO);

    /**
     * Updates an existing purchase invoice.
     *
     * @param id        the ID of the purchase invoice to update.
     * @param updateDTO the data to update the purchase invoice with.
     * @return an InvoiceResponse DTO representing the updated purchase invoice.
     * @throws jakarta.persistence.EntityNotFoundException if no invoice is found with the given ID.
     */
    PurchaseInvoiceDTO.InvoiceResponse updateInvoice(Long id, @Valid PurchaseInvoiceDTO.Update updateDTO);

    /**
     * Deletes a purchase invoice by its ID.
     *
     * @param id the ID of the purchase invoice to delete.
     * @throws jakarta.persistence.EntityNotFoundException if no invoice is found with the given ID.
     */
    void deleteInvoice(Long id);
}
