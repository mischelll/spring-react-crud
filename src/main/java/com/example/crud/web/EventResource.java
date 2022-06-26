package com.example.crud.web;

import com.example.crud.service.EventService;
import com.example.crud.service.dto.EventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * The type Event resource.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, maxAge = 3600)
public class EventResource {

    private final EventService eventService;

    private final Logger log = LoggerFactory.getLogger(EventResource.class);

    /**
     * Instantiates a new Event resource.
     *
     * @param eventService the event service
     */
    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> findAll(){
        log.info("REST request to find all Events!");
        List<EventDTO> allEvents = eventService.findAll();
        return ResponseEntity.ok(allEvents);
    }

    /**
     * Get one response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getOne(@PathVariable String id){
        log.info("REST request to find one Event by id: {}", id);
        EventDTO eventById = eventService.findOne(id);
        return ResponseEntity.ok(eventById);
    }

    /**
     * Create one response entity.
     *
     * @param eventDTO the event dto
     * @return the response entity
     */
    @PostMapping("/events")
    public ResponseEntity<EventDTO> createOne(@RequestBody EventDTO eventDTO){
        log.info("REST request to create Event: {}", eventDTO);
        EventDTO createEvent = eventService.save(eventDTO);
        return ResponseEntity.created(URI.create("/api/v1/events")).body(createEvent);
    }

    /**
     * Partially update one response entity.
     *
     * @param eventDTO the event dto
     * @return the response entity
     */
    @PatchMapping("/events")
    public ResponseEntity<EventDTO> partiallyUpdateOne(@RequestBody EventDTO eventDTO){
        log.info("REST request to partially update Event: {}", eventDTO);
        EventDTO partialUpdatedEvent = eventService.partialUpdate(eventDTO);
        return ResponseEntity.ok(partialUpdatedEvent);
    }

    /**
     * Delete one response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable String id){
        log.info("REST request to delete Event by id: {}", id);
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
