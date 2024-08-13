package org.adem.hospitalmanagement.dto.request;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Medication;
import org.adem.hospitalmanagement.model.Patient;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionRequest {

    private LocalDateTime localDateTime;
    private Doctor doctor;
    private Patient patient;
    private List<Medication> medication;
    private String instructions;
    private boolean isValid;
}
