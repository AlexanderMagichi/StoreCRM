package com.storecrm.storecrm.service.supplierservice;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Interface for managing supplierservice-related operations.
 */
public interface SupplierService {

    /**
     * Retrieves all suppliers.
     *
     * @return a list of SupplierResponse DTOs representing all suppliers.
     */
    List<SupplierDTO.SupplierResponse> getAllSuppliers();

    /**
     * Retrieves a supplierservice by its ID.
     *
     * @param id the ID of the supplierservice to retrieve.
     * @return a SupplierResponse DTO representing the retrieved supplierservice.
     * @throws EntityNotFoundException if the supplierservice with the given ID does not exist.
     */
    SupplierDTO.SupplierResponse getSupplierById(Long id) throws EntityNotFoundException;

    /**
     * Creates a new supplierservice.
     *
     * @param supplierDTO the data for the supplierservice to create.
     * @return a SupplierResponse DTO representing the created supplierservice.
     */
    SupplierDTO.SupplierResponse createSupplier(SupplierDTO.Create supplierDTO);

    /**
     * Deletes a supplierservice by its ID.
     *
     * @param id the ID of the supplierservice to delete.
     * @throws EntityNotFoundException if the supplierservice with the given ID does not exist.
     */
    void deleteSupplier(Long id) throws EntityNotFoundException;
}
