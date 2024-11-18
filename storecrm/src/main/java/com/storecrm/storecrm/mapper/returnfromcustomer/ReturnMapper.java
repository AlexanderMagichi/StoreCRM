package com.storecrm.storecrm.mapper.returnfromcustomer;

import com.storecrm.storecrm.model.returnfromcustomer.Return;
import com.storecrm.storecrm.dto.returnfromcustomer.ReturnDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface to convert between {@link Return} entity and {@link ReturnDTO}.
 */
@Mapper(componentModel = "spring")
public interface ReturnMapper {

    /**
     * Converts {@link Return} entity to {@link ReturnDTO}.
     *
     * @param returnEntity the Return entity to be converted
     * @return the corresponding ReturnDTO
     */
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "returnDate", target = "returnDate")
    @Mapping(source = "purchaseInvoiceId", target = "purchaseInvoiceId")
    ReturnDTO toDto(Return returnEntity);

    /**
     * Converts {@link ReturnDTO} to {@link Return} entity.
     *
     * @param returnDTO the ReturnDTO to be converted
     * @return the corresponding Return entity
     */
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "returnDate", target = "returnDate")
    @Mapping(source = "purchaseInvoiceId", target = "purchaseInvoiceId")
    Return toEntity(ReturnDTO returnDTO);
}
