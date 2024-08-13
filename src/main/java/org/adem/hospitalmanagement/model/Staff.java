package org.adem.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.RoleEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
    private String email;
    private String phoneNumber;
    private String department;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
