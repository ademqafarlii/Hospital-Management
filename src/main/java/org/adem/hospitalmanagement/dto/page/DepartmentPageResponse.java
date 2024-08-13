package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentPageResponse {
    private List<DepartmentResponse> departmentList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
