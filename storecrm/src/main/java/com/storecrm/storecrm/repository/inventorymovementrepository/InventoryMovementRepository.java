package com.storecrm.storecrm.repository.inventorymovementrepository;

import com.storecrm.storecrm.model.inventorymovement.InventoryMovement;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, Long> {

    /**
     * Deletes all inventory movements associated with a specific ReturnInvoice.
     *
     * @param returnInvoiceId the ID of the ReturnInvoice
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM InventoryMovement im WHERE im.referenceType = 'ReturnInvoice' AND im.referenceId = :returnInvoiceId")
    void deleteByReturnInvoiceId(@Param("returnInvoiceId") Long returnInvoiceId);


}
