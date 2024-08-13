package org.adem.hospitalmanagement.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentPageResponse {
    private List<AppointmentResponseDto> appointmentList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
