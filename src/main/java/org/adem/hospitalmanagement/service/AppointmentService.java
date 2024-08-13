package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.AppointmentPageResponse;
import org.adem.hospitalmanagement.dto.request.AppointmentRequestDto;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;

public interface AppointmentService {
    void addAppointment(AppointmentRequestDto appointmentRequestDto);
    AppointmentPageResponse getAllAppointments(Integer page, Integer count);
    AppointmentResponseDto getAppointmentById(Integer id);
    void deleteAppointmentById(Integer id);
    void updateAppointmentById(AppointmentRequestDto appointmentRequestDto,Integer id);
}
