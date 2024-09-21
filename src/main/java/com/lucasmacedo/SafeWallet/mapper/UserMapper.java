package com.lucasmacedo.SafeWallet.mapper;

import com.lucasmacedo.SafeWallet.DTO.UserDTO;
import com.lucasmacedo.SafeWallet.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE  = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "dataCriacao", ignore = true)
    User toUser(UserDTO userDTO);

    @Mapping(target = "senha", ignore = true)
    UserDTO toUserDTO(User user);

}
