package com.example.crud.repository;

import com.example.crud.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Event repository.
 */
public interface EventRepository extends JpaRepository<Event, String> {
}
