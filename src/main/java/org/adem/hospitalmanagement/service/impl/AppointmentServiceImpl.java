package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.AppointmentPageResponse;
import org.adem.hospitalmanagement.dto.request.AppointmentRequestDto;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;
import org.adem.hospitalmanagement.exception.AppointmentNotFoundException;
import org.adem.hospitalmanagement.mapper.AppointmentMapper;
import org.adem.hospitalmanagement.model.Appointment;
import org.adem.hospitalmanagement.model.Patient;
import org.adem.hospitalmanagement.repository.AppointmentRepository;
import org.adem.hospitalmanagement.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public void addAppointment(AppointmentRequestDto appointmentRequestDto){
        appointmentRepository.save(appointmentMapper.toAppointmentEntity(appointmentRequestDto));
    }
    @Override
    public AppointmentPageResponse getAllAppointments(Integer page, Integer count){
        Page<Appointment> appointmentPage = appointmentRepository.findAll(PageRequest.of(page,count));
        if (appointmentPage.isEmpty()){
            throw new AppointmentNotFoundException("Appointment not found");
        }
        return new AppointmentPageResponse(
                appointmentPage.getContent().stream().map(appointmentMapper::toAppointmentResponse).collect(Collectors.toList()),
                appointmentPage.getTotalPages(),
                appointmentPage.getTotalElements(),
                appointmentPage.hasNext()
        );
    }
    @Override
    public AppointmentResponseDto getAppointmentById(Integer id){
        return appointmentRepository.findById(id)
                .stream()
                .map(appointmentMapper::toAppointmentResponse)
                .findFirst()
                .orElseThrow(()->new AppointmentNotFoundException("Appointment not found"));
    }


    @Override
    public void deleteAppointmentById(Integer id){
        if (appointmentRepository.findById(id).isEmpty()){
            throw new AppointmentNotFoundException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointmentById(AppointmentRequestDto appointmentRequestDto,Integer id) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isEmpty()){
            throw new AppointmentNotFoundException("Appointment not found");
        }
        existingAppointment.get().setDate(appointmentRequestDto.getDate());
        existingAppointment.get().setDoctor(appointmentRequestDto.getDoctor());
        existingAppointment.get().setReason(appointmentRequestDto.getReason());
        existingAppointment.get().setPatient(appointmentRequestDto.getPatient());
        existingAppointment.get().setStatus(appointmentRequestDto.getStatus());

        appointmentRepository.save(existingAppointment.get());
    }

}
