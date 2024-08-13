package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.BedResponse;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BedPageResponse{
    private List<BedResponse> bedList;
    private long totalElements;
    private long totalPages;
    private boolean hasNext;
}
