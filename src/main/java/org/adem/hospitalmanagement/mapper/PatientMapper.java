package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.PatientRequest;
import org.adem.hospitalmanagement.dto.response.PatientResponse;
import org.adem.hospitalmanagement.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toPatientEntity(PatientRequest patientRequest);
    PatientResponse toPatientResponse(Patient patient);
}
