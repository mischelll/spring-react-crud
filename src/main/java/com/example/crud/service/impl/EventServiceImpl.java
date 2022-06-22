package com.example.crud.service.impl;

import com.example.crud.domain.Event;
import com.example.crud.mapper.EventMapper;
import com.example.crud.repository.EventRepository;
import com.example.crud.service.EventService;
import com.example.crud.service.dto.EventDTO;
import com.example.crud.service.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventServiceImpl implements EventService {

    private final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        log.info("Save Event: {}", eventDTO);
        Event event = eventMapper.toEntity(eventDTO);
        Event persistedEvent = eventRepository.save(event);
        return eventMapper.toDto(persistedEvent);
    }

    @Override
    public List<EventDTO> findAll() {
        log.info("Finding all Events...");
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO findOne(Long id) {
        log.info("Finding one Event by id: {}", id);
        return eventMapper.toDto(eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Event with id: %d not found!", id))));
    }

    @Override
    public EventDTO partialUpdate(EventDTO eventDTO) {
        log.info("Partially update Event: {}", eventDTO);
        Event event = eventRepository.findById(eventDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Event with id: %d not found!", eventDTO.getId())));
        eventMapper.partialUpdate(event, eventDTO);
        Event updatedEvent = eventRepository.save(event);
        return eventMapper.toDto(updatedEvent);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Event by id: {}", id);
        eventRepository.deleteById(id);
    }
}
