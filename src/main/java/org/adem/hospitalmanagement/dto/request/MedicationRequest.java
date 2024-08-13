package org.adem.hospitalmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicationRequest {

    @NotBlank(message = "medication name cannot be blank")
    private String name;
    @NotBlank(message = "manufacturer name cannot be blank")
    private String manufacturer;
    @NotNull(message = "expiry date cannot be blank")
    private LocalDateTime expiryDate;
}
