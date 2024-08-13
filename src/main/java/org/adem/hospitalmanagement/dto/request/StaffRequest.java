package org.adem.hospitalmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.adem.hospitalmanagement.enums.Gender;
import org.adem.hospitalmanagement.enums.RoleEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffRequest {
    @NotBlank(message = "firstname cannot be blank")
    private String firstName;
    @NotBlank(message = "lastname cannot be blank")
    private String lastName;
    @NotNull(message = "role cannot be null")
    private RoleEnum roleEnum;
    @NotBlank(message = "email cannot be blank")
    private String email;
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;
    @NotBlank(message = "department cannot be blank")
    private String department;
    @NotNull(message = "age cannot be null")
    private Integer age;
    @NotBlank(message = "gender cannot be blank")
    private Gender gender;


}
