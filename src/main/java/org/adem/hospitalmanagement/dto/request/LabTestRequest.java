package org.adem.hospitalmanagement.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Result;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabTestRequest {
    @NotNull(message = "test date cannot be null")
    private LocalDateTime testDate;
    @NotBlank(message = "result cannot be blank")
    private Result result;
    @NotBlank(message = "description cannot be blank")
    private String description;
    @NotBlank(message = "test name cannot be blank")
    private String testName;
    @NotNull(message = "doctor cannot be null")
    private Doctor doctor;
    @NotNull(message = "patient cannot be null")
    private Patient patient;
}
