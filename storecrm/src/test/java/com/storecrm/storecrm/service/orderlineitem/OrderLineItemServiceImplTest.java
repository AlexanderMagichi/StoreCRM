package com.storecrm.storecrm.service.orderlineitem;

import com.storecrm.storecrm.model.orderlineitem.OrderLineItem;
import com.storecrm.storecrm.repository.orderlineitem.OrderLineItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderLineItemServiceImplTest {

    @Mock
    private OrderLineItemRepository orderLineItemRepository;

    @InjectMocks
    private OrderLineItemServiceImpl orderLineItemService;

    private OrderLineItem orderLineItem;

    @BeforeEach
    void setUp() {
        orderLineItem = OrderLineItem.builder()
                .id(1L)
                .orderId(1001L)
                .productId(3001L)
                .quantity(2)
                .price(29.99)
                .build();
    }

    @Test
    void getAllLineItems_ShouldReturnListOfOrderLineItems() {
        when(orderLineItemRepository.findAll()).thenReturn(List.of(orderLineItem));

        List<OrderLineItem> result = orderLineItemService.getAllLineItems();

        assertThat(result).isNotEmpty().hasSize(1).contains(orderLineItem);
        verify(orderLineItemRepository, times(1)).findAll();
    }

    @Test
    void getLineItemById_ShouldReturnOrderLineItem() {
        when(orderLineItemRepository.findById(1L)).thenReturn(Optional.of(orderLineItem));

        Optional<OrderLineItem> result = orderLineItemService.getLineItemById(1L);

        assertThat(result).isPresent().contains(orderLineItem);
        verify(orderLineItemRepository, times(1)).findById(1L);
    }

    @Test
    void getLineItemById_ShouldReturnEmptyOptional_WhenNotFound() {
        when(orderLineItemRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<OrderLineItem> result = orderLineItemService.getLineItemById(2L);

        assertThat(result).isEmpty();
        verify(orderLineItemRepository, times(1)).findById(2L);
    }

    @Test
    void createLineItem_ShouldSaveAndReturnOrderLineItem() {
        when(orderLineItemRepository.save(orderLineItem)).thenReturn(orderLineItem);

        OrderLineItem result = orderLineItemService.createLineItem(orderLineItem);

        assertThat(result).isEqualTo(orderLineItem);
        verify(orderLineItemRepository, times(1)).save(orderLineItem);
    }

    @Test
    void updateLineItem_ShouldUpdateAndReturnOrderLineItem() {
        OrderLineItem updatedItem = OrderLineItem.builder()
                .id(1L)
                .orderId(1001L)
                .productId(4001L)
                .quantity(3)
                .price(35.99)
                .build();

        when(orderLineItemRepository.findById(1L)).thenReturn(Optional.of(orderLineItem));
        when(orderLineItemRepository.save(any(OrderLineItem.class))).thenReturn(updatedItem);

        OrderLineItem result = orderLineItemService.updateLineItem(1L, updatedItem);

        assertThat(result.getProductId()).isEqualTo(4001L);
        assertThat(result.getQuantity()).isEqualTo(3);
        assertThat(result.getPrice()).isEqualTo(35.99);

        verify(orderLineItemRepository, times(1)).findById(1L);
        verify(orderLineItemRepository, times(1)).save(any(OrderLineItem.class));
    }

    @Test
    void updateLineItem_ShouldThrowException_WhenNotFound() {
        OrderLineItem updatedItem = OrderLineItem.builder().id(1L).build();

        when(orderLineItemRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class,
                () -> orderLineItemService.updateLineItem(1L, updatedItem));

        assertThat(exception.getMessage()).isEqualTo("OrderLineItem not found with id: 1");

        verify(orderLineItemRepository, times(1)).findById(1L);
        verify(orderLineItemRepository, never()).save(any());
    }

    @Test
    void deleteLineItem_ShouldDeleteOrderLineItem() {
        doNothing().when(orderLineItemRepository).deleteById(1L);

        orderLineItemService.deleteLineItem(1L);

        verify(orderLineItemRepository, times(1)).deleteById(1L);
    }
}
