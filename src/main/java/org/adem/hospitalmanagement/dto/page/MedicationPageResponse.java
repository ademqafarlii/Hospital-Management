package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;
import org.adem.hospitalmanagement.dto.response.MedicationResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicationPageResponse {
    private List<MedicationResponse> medicationList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
