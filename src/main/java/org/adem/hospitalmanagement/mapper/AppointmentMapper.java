package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.AppointmentRequestDto;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;
import org.adem.hospitalmanagement.model.Appointment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

     AppointmentResponseDto toAppointmentResponse(Appointment appointment);
     Appointment toAppointmentEntity(AppointmentRequestDto appointmentRequestDto);
}
