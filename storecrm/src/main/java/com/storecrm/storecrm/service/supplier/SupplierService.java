package com.storecrm.storecrm.service.supplier;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Interface for managing supplier-related operations.
 */
public interface SupplierService {

    /**
     * Retrieves all suppliers.
     *
     * @return a list of SupplierResponse DTOs representing all suppliers.
     */
    List<SupplierDTO.SupplierResponse> getAllSuppliers();

    /**
     * Retrieves a supplier by its ID.
     *
     * @param id the ID of the supplier to retrieve.
     * @return a SupplierResponse DTO representing the retrieved supplier.
     * @throws EntityNotFoundException if the supplier with the given ID does not exist.
     */
    SupplierDTO.SupplierResponse getSupplierById(Long id) throws EntityNotFoundException;

    /**
     * Creates a new supplier.
     *
     * @param supplierDTO the data for the supplier to create.
     * @return a SupplierResponse DTO representing the created supplier.
     */
    SupplierDTO.SupplierResponse createSupplier(SupplierDTO.Create supplierDTO);

    /**
     * Deletes a supplier by its ID.
     *
     * @param id the ID of the supplier to delete.
     * @throws EntityNotFoundException if the supplier with the given ID does not exist.
     */
    void deleteSupplier(Long id) throws EntityNotFoundException;
}
