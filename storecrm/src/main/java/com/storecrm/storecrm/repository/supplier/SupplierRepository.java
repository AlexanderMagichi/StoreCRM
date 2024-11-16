package com.storecrm.storecrm.repository.supplier;

import com.storecrm.storecrm.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
