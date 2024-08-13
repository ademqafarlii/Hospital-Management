package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.AppointmentPageResponse;
import org.adem.hospitalmanagement.dto.request.AppointmentRequestDto;
import org.adem.hospitalmanagement.dto.response.AppointmentResponseDto;
import org.adem.hospitalmanagement.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAnyRole;

@RestController
@RequestMapping("/hospital/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addAppointment(@RequestBody @Valid AppointmentRequestDto appointmentRequestDto) {
        appointmentService.addAppointment(appointmentRequestDto);
    }

    @GetMapping("/get-all-appointments")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public AppointmentPageResponse getAllAppointments(@RequestParam Integer page, @RequestParam Integer count) {
        return appointmentService.getAllAppointments(page, count);
    }


    @GetMapping("/get-appointment-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public AppointmentResponseDto getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/delete-appointment-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteAppointmentById(@PathVariable Integer id) {
        appointmentService.deleteAppointmentById(id);
    }

    @PatchMapping("/update-appointment-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateAppointmentById(@RequestBody @Valid AppointmentRequestDto appointmentRequestDto, @PathVariable Integer id) {
        appointmentService.updateAppointmentById(appointmentRequestDto, id);
    }

}
