package org.adem.hospitalmanagement.dto.response;

import lombok.*;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Patient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponse {

    private Status roomStatus;
    private List<Patient> patient;
    private Doctor doctor;
}
