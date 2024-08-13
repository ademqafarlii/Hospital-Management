package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.OperationRequest;
import org.adem.hospitalmanagement.dto.response.OperationResponse;
import org.adem.hospitalmanagement.model.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {
    Operation toOperationEntity(OperationRequest operationRequest);
    OperationResponse toOperationResponse(Operation operation);
}
