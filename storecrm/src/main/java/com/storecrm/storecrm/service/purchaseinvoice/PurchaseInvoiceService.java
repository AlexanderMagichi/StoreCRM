package com.storecrm.storecrm.service.purchaseinvoice;

import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Create;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Update;

import java.util.List;

/**
 * Service interface for managing purchase invoices.
 */
public interface PurchaseInvoiceService {

    /**
     * Retrieves all purchase invoices.
     *
     * @return a list of purchase invoice DTOs.
     */
    List<PurchaseInvoiceDTO> getAllInvoices();

    /**
     * Retrieves a specific purchase invoice by its ID.
     *
     * @param id the ID of the purchase invoice.
     * @return the purchase invoice DTO.
     */
    PurchaseInvoiceDTO getInvoiceById(Long id);

    /**
     * Creates a new purchase invoice.
     *
     * @param dto the DTO containing purchase invoice creation data.
     * @return the created purchase invoice DTO.
     */
    PurchaseInvoiceDTO createInvoice(Create dto);

    /**
     * Updates an existing purchase invoice.
     *
     * @param id  the ID of the purchase invoice to update.
     * @param dto the DTO containing purchase invoice update data.
     * @return the updated purchase invoice DTO.
     */
    PurchaseInvoiceDTO updateInvoice(Long id, Update dto);

    /**
     * Deletes a purchase invoice by its ID.
     *
     * @param id the ID of the purchase invoice to delete.
     */
    void deleteInvoice(Long id);
}
