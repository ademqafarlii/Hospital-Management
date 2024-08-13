package org.adem.hospitalmanagement.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor
@Builder
public class OperationRequest {
    @NotBlank(message = "operation name cannot be blank")
    private String operationName;
    @NotBlank(message = "description cannot be blank")
    private String description;
    @NotNull(message = "date cannot be null")
    private LocalDateTime operationDate;
    @NotNull(message = "patient cannot be null")
    private Patient patient;
    @NotNull(message = "doctor cannot be null")
    private Doctor doctor;
    @NotBlank(message = "status cannot be blank")
    private Status status;
}
