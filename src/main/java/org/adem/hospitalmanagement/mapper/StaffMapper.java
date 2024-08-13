package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.StaffRequest;
import org.adem.hospitalmanagement.dto.response.StaffResponse;
import org.adem.hospitalmanagement.model.Staff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    Staff toStaffEntity(StaffRequest staffRequest);
    StaffResponse toStaffResponse(Staff staff);
}
