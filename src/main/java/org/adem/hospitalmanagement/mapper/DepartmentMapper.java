package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.DepartmentRequest;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;
import org.adem.hospitalmanagement.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toDepartmentEntity(DepartmentRequest departmentRequest);
    DepartmentResponse toDepartmentResponse(Department department);
}
