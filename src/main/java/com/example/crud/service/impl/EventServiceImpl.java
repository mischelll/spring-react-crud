package com.example.crud.service.impl;

import com.example.crud.repository.EventRepository;
import com.example.crud.service.EventService;
import com.example.crud.service.dto.EventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Event by id: {}", id);

    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        log.info("Save Event: {}", eventDTO);
        return null;
    }

    @Override
    public List<EventDTO> findAll() {
        log.info("Finding all Events...");
        return null;
    }

    @Override
    public EventDTO findOne(Long id) {
        log.info("Finding one Event by id: {}", id);
        return null;
    }
}
