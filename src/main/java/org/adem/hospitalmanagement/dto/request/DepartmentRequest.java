package org.adem.hospitalmanagement.dto.request;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.model.Doctor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequest {
    @NotNull(message = "department name cannot be blank")
    private String name;
    @NotNull(message = "doctor cannot be null")
    private Doctor headOfDepartment;
}
