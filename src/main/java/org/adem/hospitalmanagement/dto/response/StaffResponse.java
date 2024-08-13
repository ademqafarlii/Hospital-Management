package org.adem.hospitalmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.RoleEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffResponse {
    private String firstName;
    private String lastName;
    private RoleEnum roleEnum;
    private String email;
    private String phoneNumber;
    private String department;
    private Integer age;
    private Gender gender;

}
