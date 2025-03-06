package com.storecrm.storecrm.repository.returninvoice;

import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnInvoiceRepository extends JpaRepository<ReturnInvoice, Long> {

    List<ReturnInvoice> findBySupplierId(Long supplierId);

    List<ReturnInvoice> findByStatus(String status);

    List<ReturnInvoice> findByDateBetween(java.sql.Timestamp startDate, java.sql.Timestamp endDate);


}
