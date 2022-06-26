package com.example.crud.mapper;

import com.example.crud.domain.User;
import com.example.crud.service.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 * The interface User mapper.
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User>{

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);

    /**
     * From id user.
     *
     * @param id the id
     * @return the user
     */
    default User fromId(Long id){
        if(id == null){
            return null;
        }

        User user = new User();
        user.setId(id);
        return user;
    }
}
