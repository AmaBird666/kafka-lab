package ru.voroncov.cloudcomputing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.voroncov.cloudcomputing.dto.request.user.CreateUserRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.user.UserResponseDTO;
import ru.voroncov.cloudcomputing.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toModel(CreateUserRequestDTO userRequestDTO);

    UserResponseDTO toDto(User user);

}
