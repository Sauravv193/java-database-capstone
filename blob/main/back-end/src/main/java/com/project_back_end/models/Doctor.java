
package com.project_back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String specialization;

    @ElementCollection
    private List<String> availableTimes; // Example: ["Monday 10-12", "Wednesday 2-4"]

    // Getters and setters
}
