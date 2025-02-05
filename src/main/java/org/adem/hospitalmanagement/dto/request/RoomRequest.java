package org.adem.hospitalmanagement.dto.request;

import lombok.*;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomRequest {

    private Status roomStatus;
    private List<Patient> patient;
    private Doctor doctor;
}
