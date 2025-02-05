package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Medication> medications;

    private String instructions;
    private boolean isValid;
}
