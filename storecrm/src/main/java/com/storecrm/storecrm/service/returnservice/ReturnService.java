package com.storecrm.storecrm.service.returnservice;

import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;

import java.util.List;
import java.util.Optional;

public interface ReturnService {

    /**
     * Retrieves all return invoices.
     *
     * @return a list of all return invoices.
     */
    List<ReturnInvoice> getAllReturns();

    /**
     * Retrieves a specific return invoice by its ID.
     *
     * @param id the ID of the return invoice to retrieve.
     * @return an Optional containing the return invoice if found, otherwise empty.
     */
    Optional<ReturnInvoice> getReturnById(Long id);

    /**
     * Creates a new return invoice.
     *
     * @param returnInvoice the return invoice to create.
     * @return the created return invoice.
     */
    ReturnInvoice createReturn(ReturnInvoice returnInvoice);

    /**
     * Updates an existing return invoice.
     *
     * @param returnInvoice the return invoice with updated information.
     * @return the updated return invoice.
     */
    ReturnInvoice updateReturn(ReturnInvoice returnInvoice);

    /**
     * Deletes a return invoice by its ID.
     *
     * @param id the ID of the return invoice to delete.
     */
    void deleteReturn(Long id);
}
