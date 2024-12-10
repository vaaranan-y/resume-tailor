package com.vyogalin.resume_tailor_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.vyogalin.resume_tailor_backend.models.AppUser;

public interface RTUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);
}