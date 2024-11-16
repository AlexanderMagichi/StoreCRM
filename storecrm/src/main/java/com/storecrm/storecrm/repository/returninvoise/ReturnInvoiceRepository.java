package com.storecrm.storecrm.repository.returninvoise;

import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnInvoiceRepository extends JpaRepository<ReturnInvoice, Long> {

}
