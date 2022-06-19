package com.example.crud.repository;

import com.example.crud.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Long, Group> {
}
