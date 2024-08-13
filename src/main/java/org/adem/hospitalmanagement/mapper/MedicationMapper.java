package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.DoctorRequest;
import org.adem.hospitalmanagement.dto.request.MedicationRequest;
import org.adem.hospitalmanagement.dto.response.MedicationResponse;
import org.adem.hospitalmanagement.model.Medication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    Medication toMedicationEntity(MedicationRequest medicationRequest);
    MedicationResponse toMedicationResponse(Medication medication);
}
