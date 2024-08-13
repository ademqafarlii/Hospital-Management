package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Status status;

    @ManyToOne
    private Room room;
    @OneToOne
    private Patient patient;
}
