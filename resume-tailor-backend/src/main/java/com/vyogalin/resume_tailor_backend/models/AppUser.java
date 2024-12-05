package com.vyogalin.resume_tailor_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor 
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String email;
    private String name;
    private List<String> applicationIds; // Uniquely stored in Applications Table

    // Things to keep in mind;
    /*
        1. Join user and application table on applicationIds
        2. Add lazy getters for lazy loading (i.e. make loading PDFs more efficient)
     */ 

    public AppUser(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}