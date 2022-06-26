package com.example.crud.service;

import com.example.crud.service.dto.UserDTO;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find by id user dto.
     *
     * @param id the id
     * @return the user dto
     */
    UserDTO findById(Long id);
}
