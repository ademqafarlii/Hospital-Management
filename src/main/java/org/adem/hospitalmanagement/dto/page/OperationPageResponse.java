package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;
import org.adem.hospitalmanagement.dto.response.OperationResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationPageResponse {
    private List<OperationResponse> departmentList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
