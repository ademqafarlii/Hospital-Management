package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.DoctorRequest;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;
import org.adem.hospitalmanagement.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctorEntity(DoctorRequest doctorRequest);
    DoctorResponse toDoctorResponse(Doctor doctor);
}
