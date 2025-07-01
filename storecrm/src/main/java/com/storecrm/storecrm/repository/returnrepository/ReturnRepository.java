package com.storecrm.storecrm.repository.returnrepository;

import com.storecrm.storecrm.model.returnfromcustomer.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {

}
