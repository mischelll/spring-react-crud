package com.example.crud.service.impl;

import com.example.crud.domain.Group;
import com.example.crud.mapper.GroupMapper;
import com.example.crud.repository.GroupRepository;
import com.example.crud.service.GroupService;
import com.example.crud.service.dto.GroupDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {

    private final Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Group by id: {}", id);
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        log.info("Create Group: {}", groupDTO);
        Group entity = groupMapper.toEntity(groupDTO);
        Group group = groupRepository.save(entity);
        return groupMapper.toDto(group);
    }

    @Override
    public List<GroupDTO> findAll() {
        return null;
    }

    @Override
    public GroupDTO findOne(Long id) {
        return null;
    }
}
