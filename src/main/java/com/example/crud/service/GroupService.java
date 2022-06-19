package com.example.crud.service;

import com.example.crud.service.dto.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GroupService {

    void delete(Long id);

    GroupDTO save(GroupDTO eventDTO);

    List<GroupDTO> findAll();

    GroupDTO findOne(Long id);
}
