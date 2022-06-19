package com.example.crud.service;

import com.example.crud.service.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    void delete(Long id);

    GroupDTO save(GroupDTO eventDTO);

    List<GroupDTO> findAll();

    GroupDTO findOne(Long id);
}
