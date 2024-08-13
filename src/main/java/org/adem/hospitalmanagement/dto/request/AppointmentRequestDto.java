package org.adem.hospitalmanagement.dto.request;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AppointmentRequestDto {

    @NotNull(message = "date cannot be null")
    private LocalDateTime date;

    @NotNull(message = "status cannot be null")
    private Status status;

    @NotNull(message = "patient cannot be null")
    private Patient patient;

    @NotNull(message = "doctor cannot be null")
    private Doctor doctor;

    @NotBlank(message = "reason cannot be blank")
    private String reason;
}
