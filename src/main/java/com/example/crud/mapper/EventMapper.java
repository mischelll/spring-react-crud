package com.example.crud.mapper;

import com.example.crud.domain.Event;
import com.example.crud.service.dto.EventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toDto(Event event);

    Event toEntity(EventDTO eventDTO);

    default Event fromId(Long id) {
        if (id == null) {
            return null;
        }

        Event event = new Event();
        event.setId(id);
        return event;
    }
}
