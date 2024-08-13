package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime localDateTime;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToMany
    private List<Medication> medication;
    private String instructions;

    private boolean isValid;

}
