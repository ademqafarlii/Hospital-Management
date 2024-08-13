package org.adem.hospitalmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.model.Appointment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    @NotBlank(message = "firstname cannot be blank")
    private String firstName;
    @NotBlank(message = "lastname cannot be blank")
    private String lastName;
    @NotNull(message = "gender cannot bo null")
    private Gender gender;
    @NotNull(message = "age cannot be null")
    private Integer age;
    @NotBlank(message = "address cannot be blank")
    private String address;
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;
    @NotBlank(message = "email cannot be blank")
    private String email;
    @NotNull(message = "firstname cannot be blank")
    private LocalDateTime dateOfBirth;
    @NotNull(message = "medical history cannot be null. If patient doesn't have medical history then write empty")
    private String medicalHistory;
    private List<Appointment> appointment;

}
