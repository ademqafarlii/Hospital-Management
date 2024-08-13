package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.PrescriptionRequest;
import org.adem.hospitalmanagement.dto.response.PrescriptionResponse;
import org.adem.hospitalmanagement.model.Prescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
    Prescription toPrescriptionEntity(PrescriptionRequest prescriptionRequest);
    PrescriptionResponse toPrescriptionResponse(Prescription prescription);
}
