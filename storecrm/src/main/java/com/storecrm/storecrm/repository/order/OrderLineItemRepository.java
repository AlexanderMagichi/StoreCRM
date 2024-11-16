package com.storecrm.storecrm.repository.order;


import com.storecrm.storecrm.model.order.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

}
