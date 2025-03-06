package com.storecrm.storecrm.repository.purchaseinvoicelineitem;

import com.storecrm.storecrm.model.purchaseinvoicelineitem.PurchaseInvoiceLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseInvoiceLineItemRepository extends JpaRepository<PurchaseInvoiceLineItem, Long> {


}
