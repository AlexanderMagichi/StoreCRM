package com.storecrm.storecrm.mapper.returninvoise;

import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper to convert between ReturnInvoice and ReturnInvoiceDTO.
 */
@Mapper(componentModel = "spring")
public interface ReturnInvoiceMapper {

    ReturnInvoiceMapper INSTANCE = Mappers.getMapper(ReturnInvoiceMapper.class);

    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "createdBy", target = "createdBy")
    ReturnInvoiceDTO toDto(ReturnInvoice returnInvoice);

    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "createdBy", target = "createdBy")
    ReturnInvoice toEntity(ReturnInvoiceDTO returnInvoiceDTO);



    List<ReturnInvoiceDTO> toDtoList(List<ReturnInvoice> returnInvoices);

    /**
     * Updates the existing ReturnInvoice entity from the given ReturnInvoiceDTO.
     *
     * @param returnInvoiceDTO the DTO containing the updated data
     * @param returnInvoice the entity to be updated
     */
    void updateEntityFromDto(ReturnInvoiceDTO returnInvoiceDTO, @MappingTarget ReturnInvoice returnInvoice);




}



