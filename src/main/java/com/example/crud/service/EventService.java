package com.example.crud.service;

import com.example.crud.service.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Event service.
 */
@Service
public interface EventService {

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);

    /**
     * Save event dto.
     *
     * @param eventDTO the event dto
     * @return the event dto
     */
    EventDTO save(EventDTO eventDTO);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<EventDTO> findAll();

    /**
     * Find one event dto.
     *
     * @param id the id
     * @return the event dto
     */
    EventDTO findOne(Long id);

    /**
     * Partial update event dto.
     *
     * @param eventDTO the event dto
     * @return the event dto
     */
    EventDTO partialUpdate(EventDTO eventDTO);
}
