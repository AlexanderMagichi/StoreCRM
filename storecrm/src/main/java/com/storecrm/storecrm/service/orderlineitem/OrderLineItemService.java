package com.storecrm.storecrm.service.orderlineitem;

import com.storecrm.storecrm.model.orderlineitem.OrderLineItem;

import java.util.List;
import java.util.Optional;

public interface OrderLineItemService {
    List<OrderLineItem> getAllLineItems();
    Optional<OrderLineItem> getLineItemById(Long id);
    OrderLineItem createLineItem(OrderLineItem lineItem);
    OrderLineItem updateLineItem(Long id, OrderLineItem updatedLineItem);
    void deleteLineItem(Long id);
}
