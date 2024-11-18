package com.storecrm.storecrm.mapper.user;

import com.storecrm.storecrm.model.user.User;
import com.storecrm.storecrm.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for converting between User entity and UserDTO.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user the User entity to be converted
     * @return the UserDTO
     */
    @Mapping(source = "roleId", target = "role") // Mapping roleId to role in DTO
    UserDTO toDto(User user);

    /**
     * Converts a UserDTO to a User entity.
     *
     * @param userDTO the UserDTO to be converted
     * @return the User entity
     */
    @Mapping(source = "role", target = "roleId") // Mapping role to roleId in entity
    User toEntity(UserDTO userDTO);
}
