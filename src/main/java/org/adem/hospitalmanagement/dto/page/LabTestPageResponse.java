package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.LabTestResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabTestPageResponse {
    private List<LabTestResponse> labTestList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
