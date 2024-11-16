package com.storecrm.storecrm.repository.product;

import com.storecrm.storecrm.model.product.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, Long> {


}
