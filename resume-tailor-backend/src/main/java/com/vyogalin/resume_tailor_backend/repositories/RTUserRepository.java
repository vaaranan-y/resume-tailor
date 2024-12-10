package com.vyogalin.resume_tailor_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.vyogalin.resume_tailor_backend.models.RTUser;

public interface RTUserRepository extends JpaRepository<RTUser, Long> {
    RTUser findByUsername(String username);
    RTUser findByEmail(String email);
}