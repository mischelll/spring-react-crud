package com.example.crud.service.impl;

import com.example.crud.domain.Group;
import com.example.crud.mapper.GroupMapper;
import com.example.crud.repository.GroupRepository;
import com.example.crud.service.GroupService;
import com.example.crud.service.dto.GroupDTO;
import com.example.crud.service.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
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
        log.info("Find all Groups.");
        return groupRepository
                .findAll()
                .stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDTO findOne(Long id) {
        log.info("Find Group by id: {}", id);
        return groupMapper.toDto(groupRepository.findById(id).orElse(null));
    }

    @Override
    public GroupDTO partialUpdate(Long id, GroupDTO groupDTO) {
        log.info("Update Group: {}", groupDTO);
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Group with id: %d not found!", id)));
        groupMapper.partialUpdate(group, groupDTO);
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.toDto(updatedGroup);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Group by id: {}", id);
        groupRepository.deleteById(id);
    }

}
