package com.example.crud.repository;

import com.example.crud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
