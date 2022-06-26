package com.example.crud.service;

import com.example.crud.service.dto.GroupDTO;

import java.util.List;

/**
 * The interface Group service.
 */
public interface GroupService {

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

    /**
     * Save group dto.
     *
     * @param eventDTO the event dto
     * @return the group dto
     */
    GroupDTO save(GroupDTO eventDTO);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<GroupDTO> findAll();

    /**
     * Find one group dto.
     *
     * @param id the id
     * @return the group dto
     */
    GroupDTO findOne(String id);

    /**
     * Partial update group dto.
     *
     * @param id       the id
     * @param groupDTO the group dto
     * @return the group dto
     */
    GroupDTO partialUpdate(String id, GroupDTO groupDTO);

    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<GroupDTO> findAllByUserId(String userId);
}
