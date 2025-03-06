package com.storecrm.storecrm.service.orderlineitem;

import com.storecrm.storecrm.model.orderlineitem.OrderLineItem;
import com.storecrm.storecrm.repository.orderlineitem.OrderLineItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderLineItemServiceImpl implements OrderLineItemService {
    private final OrderLineItemRepository orderLineItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderLineItem> getAllLineItems() {
        return orderLineItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderLineItem> getLineItemById(Long id) {
        return orderLineItemRepository.findById(id);
    }

    @Override
    @Transactional
    public OrderLineItem createLineItem(OrderLineItem lineItem) {
        return orderLineItemRepository.save(lineItem);
    }

    @Override
    @Transactional
    public OrderLineItem updateLineItem(Long id, OrderLineItem updatedLineItem) {
        return orderLineItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setProductId(updatedLineItem.getProductId());
                    existingItem.setQuantity(updatedLineItem.getQuantity());
                    existingItem.setPrice(updatedLineItem.getPrice());
                    return orderLineItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new RuntimeException("OrderLineItem not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteLineItem(Long id) {
        orderLineItemRepository.deleteById(id);
    }
}
