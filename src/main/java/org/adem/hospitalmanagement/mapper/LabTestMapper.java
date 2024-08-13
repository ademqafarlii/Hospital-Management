package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.LabTestRequest;
import org.adem.hospitalmanagement.dto.response.LabTestResponse;
import org.adem.hospitalmanagement.model.LabTest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LabTestMapper {

    LabTest toLabTestEntity(LabTestRequest labTestRequest);
    LabTestResponse toLabTestResponse(LabTest labTest);
}
