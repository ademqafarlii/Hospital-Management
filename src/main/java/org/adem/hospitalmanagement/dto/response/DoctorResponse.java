package org.adem.hospitalmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.model.Appointment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponse {
    private String firstName;
    private String lastName;
    private Specialization specialization;
    private Integer yearsOfExperience;
    private String phoneNumber;
    private String email;
    private String department;
    private Integer age;
    private Gender gender;
    private List<Appointment> appointment;
}
