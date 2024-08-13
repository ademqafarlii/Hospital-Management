package org.adem.hospitalmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Result;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabTestResponse {
    private LocalDateTime testDate;

    private Result result;
    private String description;
    private String testName;

    private Doctor doctor;

    private Patient patient;

}
