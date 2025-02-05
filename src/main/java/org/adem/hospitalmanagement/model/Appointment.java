package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    private String reason;
}
