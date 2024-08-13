package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorPageResponse {
    private List<DoctorResponse> doctorList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
