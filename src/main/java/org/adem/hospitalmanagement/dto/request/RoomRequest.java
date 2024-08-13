package org.adem.hospitalmanagement.dto.request;

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
public class RoomRequest {

    private Status roomStatus;
    private List<Patient> patient;
    private Doctor doctor;
}
