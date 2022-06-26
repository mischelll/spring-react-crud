package com.example.crud.repository;

import com.example.crud.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Group repository.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Group> findAllByUserId(Long userId);
}
