package com.example.crud.mapper;

import com.example.crud.domain.Event;
import com.example.crud.service.dto.EventDTO;
import org.mapstruct.Mapper;

/**
 * The interface Event mapper.
 */
@Mapper(componentModel = "spring")
public interface EventMapper extends EntityMapper<EventDTO, Event> {

    EventDTO toDto(Event event);

    Event toEntity(EventDTO eventDTO);

    /**
     * From id event.
     *
     * @param id the id
     * @return the event
     */
    default Event fromId(Long id) {
        if (id == null) {
            return null;
        }

        Event event = new Event();
        event.setId(id);
        return event;
    }
}
