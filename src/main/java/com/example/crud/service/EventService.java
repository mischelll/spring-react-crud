package com.example.crud.service;

import com.example.crud.service.dto.EventDTO;

import java.util.List;

public interface EventService {

    void delete(Long id);

    EventDTO save(EventDTO eventDTO);

    List<EventDTO> findAll();

    EventDTO findOne(Long id);
}
