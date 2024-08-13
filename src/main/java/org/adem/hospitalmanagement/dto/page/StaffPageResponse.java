package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.PatientResponse;
import org.adem.hospitalmanagement.dto.response.StaffResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffPageResponse {
    private List<StaffResponse> staffList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
