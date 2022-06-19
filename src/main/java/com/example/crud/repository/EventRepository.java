package com.example.crud.repository;

import com.example.crud.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Long, Event> {
}
