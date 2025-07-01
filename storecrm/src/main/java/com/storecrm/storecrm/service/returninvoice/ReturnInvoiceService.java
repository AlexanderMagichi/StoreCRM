package com.storecrm.storecrm.service.returninvoice;

import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;

import java.util.List;

public interface ReturnInvoiceService {

    /**
     * Retrieves all return invoices.
     *
     * @return a list of ReturnInvoiceDTOs
     */
    List<ReturnInvoiceDTO> getAllReturnInvoices();

    /**
     * Retrieves a specific return invoice by its ID.
     *
     * @param id the ID of the return invoice
     * @return the corresponding ReturnInvoiceDTO
     */
    ReturnInvoiceDTO getReturnInvoiceById(Long id);

    /**
     * Creates a new return invoice.
     *
     * @param returnInvoiceDTO the data to create a return invoice
     * @return the created ReturnInvoiceDTO
     */
    ReturnInvoiceDTO createReturnInvoice(ReturnInvoiceDTO returnInvoiceDTO);

    /**
     * Updates an existing return invoice.
     *
     * @param id               the ID of the return invoice to update
     * @param returnInvoiceDTO the updated data
     * @return the updated ReturnInvoiceDTO
     */
    ReturnInvoiceDTO updateReturnInvoice(Long id, ReturnInvoiceDTO returnInvoiceDTO);

    /**
     * Deletes a return invoice by its ID.
     *
     * @param id the ID of the return invoice to delete
     */
    void deleteReturnInvoice(Long id);
}
