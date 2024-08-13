package org.adem.hospitalmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.model.Appointment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    @NotBlank(message = "name cannot be blank")
    private String firstName;
    @NotBlank(message = "surname cannot be blank")
    private String lastName;
    @NotBlank(message = "specialization cannot be blank")
    private Specialization specialization;
    @NotNull(message = "experience cannot be null")
    private Integer yearsOfExperience;
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;
    @NotBlank(message = "email cannot be blank")
    private String email;
    @NotBlank(message = "department cannot be blank")
    private String department;
    @NotNull(message = "age cannot be null")
    private Integer age;
    @NotNull(message = "gender cannot be null")
    private Gender gender;
    private List<Appointment> appointment;
}
