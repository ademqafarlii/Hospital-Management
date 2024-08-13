package org.adem.hospitalmanagement.dto.page;

import lombok.*;
import org.adem.hospitalmanagement.dto.response.RoomResponse;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RoomPageResponse {
    private List<RoomResponse> roomList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
