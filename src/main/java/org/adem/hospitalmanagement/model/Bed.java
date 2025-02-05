package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.adem.hospitalmanagement.enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Room room;

    @OneToOne
    @JsonIgnore
    private Patient patient;
}
