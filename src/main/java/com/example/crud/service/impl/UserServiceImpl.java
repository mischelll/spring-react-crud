package com.example.crud.service.impl;

import com.example.crud.mapper.UserMapper;
import com.example.crud.repository.UserRepository;
import com.example.crud.service.UserService;
import com.example.crud.service.dto.UserDTO;
import com.example.crud.service.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDTO findById(Long id) {
        log.info("Find User by id: {}", id);
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with id: %d", id))));
    }
}
