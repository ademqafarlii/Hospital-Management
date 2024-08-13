package org.adem.hospitalmanagement.dto.response;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.model.Patient;
import org.adem.hospitalmanagement.model.Room;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BedResponse {

    private Status status;
    private Room room;
    private Patient patient;
}
