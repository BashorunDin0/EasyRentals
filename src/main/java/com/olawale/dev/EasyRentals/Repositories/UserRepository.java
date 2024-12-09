package com.olawale.dev.EasyRentals.Repositories;

import com.olawale.dev.EasyRentals.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by username
    Optional<User> findByUsername(String username);

    // Find user by email (optional, if you need it)
    Optional<User> findByEmail(String email);
}