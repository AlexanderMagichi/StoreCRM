package com.storecrm.storecrm.repository.purchaseinvoice;

import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

}
