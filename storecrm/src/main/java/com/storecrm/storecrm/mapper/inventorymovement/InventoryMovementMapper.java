package com.storecrm.storecrm.mapper.inventorymovement;

import com.storecrm.storecrm.model.inventorymovement.InventoryMovement;
import com.storecrm.storecrm.dto.inventorymovementdto.InventoryMovementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;

/**
 * Mapper for converting between InventoryMovement entity and InventoryMovementDTO.
 */
@Mapper(componentModel = "spring")
public interface InventoryMovementMapper {

    InventoryMovementMapper INSTANCE = Mappers.getMapper(InventoryMovementMapper.class);

    /**
     * Converts an InventoryMovement entity to an InventoryMovementDTO.
     *
     * @param inventoryMovement the InventoryMovement entity to be converted
     * @return the InventoryMovementDTO
     */
    @Mapping(source = "movementDate", target = "movementDate")
    @Mapping(source = "referenceId", target = "referenceId")
    InventoryMovementDTO toDto(InventoryMovement inventoryMovement);

    /**
     * Converts an InventoryMovementDTO to an InventoryMovement entity.
     *
     * @param inventoryMovementDTO the InventoryMovementDTO to be converted
     * @return the InventoryMovement entity
     */
    @Mapping(source = "movementDate", target = "movementDate")
    @Mapping(source = "referenceId", target = "referenceId")
    InventoryMovement toEntity(InventoryMovementDTO inventoryMovementDTO);

    /**
     * Converts a Timestamp to LocalDateTime.
     *
     * @param timestamp the Timestamp to convert
     * @return the corresponding LocalDateTime
     */
    default java.time.LocalDateTime map(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    /**
     * Converts a LocalDateTime to Timestamp.
     *
     * @param localDateTime the LocalDateTime to convert
     * @return the corresponding Timestamp
     */
    default Timestamp map(java.time.LocalDateTime localDateTime) {
        return localDateTime != null ? Timestamp.valueOf(localDateTime) : null;
    }
}
