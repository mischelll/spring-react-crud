package com.example.crud.service;

import com.example.crud.service.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {

    void delete(Long id);

    EventDTO save(EventDTO eventDTO);

    List<EventDTO> findAll();

    EventDTO findOne(Long id);
}
