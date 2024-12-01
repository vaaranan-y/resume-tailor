package com.vyogalin.resume_tailor_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.List;
import java.util.HashMap;

@Entity
@Getter @Setter @NoArgsConstructor 
public class ResumeData { 

    private long userId;
    private String surname;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String link1;
    private String link2;

    private String school;
    private String degree;
    private String schoolLocation;
    private String schoolStartDate;
    private String schoolEndDate;

    // private Experience[] experiences;
    // private Project[] projects;
    private HashMap<String, String[]> skills;



}