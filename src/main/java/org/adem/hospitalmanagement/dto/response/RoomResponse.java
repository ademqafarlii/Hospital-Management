package org.adem.hospitalmanagement.dto.response;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import java.util.List;

@Data
@AllArgsConstructor
@NonNull
@Builder
public class RoomResponse {

    private Status roomStatus;
    private List<Patient> patient;
    private Doctor doctor;
}
