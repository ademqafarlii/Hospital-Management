package org.adem.hospitalmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String email;
    private String medicalHistory;
    private LocalDateTime dateOfBirth;
    private List<Appointment> appointment;
}
