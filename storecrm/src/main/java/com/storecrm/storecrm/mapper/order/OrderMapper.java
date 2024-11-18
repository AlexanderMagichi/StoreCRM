package com.storecrm.storecrm.mapper.order;

import com.storecrm.storecrm.dto.order.OrderDTO;
import com.storecrm.storecrm.model.order.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.math.BigDecimal;

@Component
public class OrderMapper {

    /**
     * Converts {@link Order} entity to DTO.
     *
     * @param order entity to convert
     * @return corresponding DTO
     */
    public OrderDTO toDTO(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate().toLocalDateTime());  // Convert Timestamp to LocalDateTime
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalAmount(BigDecimal.valueOf(order.getTotalAmount()));  // Convert Double to BigDecimal

        return orderDTO;
    }

    /**
     * Converts {@link OrderDTO} to entity.
     *
     * @param orderDTO DTO to convert
     * @return corresponding entity
     */
    public Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            throw new IllegalArgumentException("OrderDTO cannot be null");
        }

        // Removing redundant variable 'order' by directly returning the built entity
        return Order.builder()
                .id(orderDTO.getId())
                .date(Timestamp.valueOf(orderDTO.getDate()))  // Convert LocalDateTime to Timestamp
                .customerId(orderDTO.getCustomerId())
                .status(orderDTO.getStatus())
                .totalAmount(orderDTO.getTotalAmount().doubleValue())  // Convert BigDecimal to Double
                .build();
    }
}
