package com.storecrm.storecrm.mapper.orderlineitem;

import com.storecrm.storecrm.dto.orderlineitemdto.OrderLineItemDTO;
import com.storecrm.storecrm.model.orderlineitem.OrderLineItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between OrderLineItem and OrderLineItemDTO.
 */
@Mapper(componentModel = "spring")
public interface OrderLineItemMapper {

    /**
     * Converts an OrderLineItem entity to its corresponding DTO.
     *
     * @param orderLineItem the OrderLineItem entity to convert
     * @return the corresponding OrderLineItemDTO
     */
    @Mapping(source = "price", target = "price")
    OrderLineItemDTO toDTO(OrderLineItem orderLineItem);

    /**
     * Converts an OrderLineItemDTO to its corresponding entity.
     *
     * @param orderLineItemDTO the OrderLineItemDTO to convert
     * @return the corresponding OrderLineItem entity
     */
    @Mapping(source = "price", target = "price")
    OrderLineItem toEntity(OrderLineItemDTO orderLineItemDTO);
}
