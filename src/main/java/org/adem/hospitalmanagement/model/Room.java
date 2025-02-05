package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.adem.hospitalmanagement.enums.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private Status roomStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @JsonIgnore
    private List<Patient> patients;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;
}
