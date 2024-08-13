package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.Specialization;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Specialization specialization;
    private Integer yearsOfExperience;
    private String phoneNumber;
    private String email;
    private String department;

    @OneToMany
    private List<Appointment> appointment;

}
