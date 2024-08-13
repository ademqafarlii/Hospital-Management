package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.DoctorPageResponse;
import org.adem.hospitalmanagement.dto.request.DoctorRequest;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;
import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hospital/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping("/add-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    private void addDoctor(@RequestBody @Valid DoctorRequest doctorRequest) {
        doctorService.addDoctor(doctorRequest);
    }

    @PatchMapping("/update-doctor-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDoctorByID(@RequestBody @Valid DoctorRequest doctorRequest, @PathVariable Integer id) {
        doctorService.updateDoctorByID(doctorRequest, id);
    }

    @PatchMapping("/update-doctor-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDoctorByFirstNameAndLastName(
            @RequestBody @Valid DoctorRequest doctorRequest, @RequestParam String firstName, @RequestParam String lastName) {
        doctorService.updateDoctorByFirstNameAndLastName(doctorRequest, firstName, lastName);
    }

    @GetMapping("/get-all-doctors")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getAllDoctors(@RequestParam Integer page, @RequestParam Integer count) {
        return doctorService.getAllDoctors(page, count);
    }

    @GetMapping("/get-doctors-by-specialization")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getDoctorsBySpecialization(
            @RequestParam Specialization specialization, @RequestParam Integer page, @RequestParam Integer count) {
        return doctorService.getDoctorsBySpecialization(specialization, page, count);
    }

    @GetMapping("/get-doctors-by-department")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getDoctorsByDepartment(
            @RequestParam String department, @RequestParam Integer page, @RequestParam Integer count) {
        return doctorService.getDoctorsByDepartment(department, page, count);
    }

    @GetMapping("/get-all-doctors-order-by-age")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getAllDoctorsOrderByID(@RequestParam Integer page, @RequestParam Integer count) {
        return doctorService.getAllDoctorsOrderByAge(page, count);
    }

    @GetMapping("/get-doctor-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorResponse getDoctorByID(@PathVariable Integer id) {
        return doctorService.getDoctorByID(id);
    }

    @GetMapping("/get-doctor-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorResponse getDoctorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return doctorService.getDoctorByFirstNameAndLastName(firstName, lastName);
    }


    @DeleteMapping("/delete-doctor-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDoctorByID(@PathVariable Integer id) {
        doctorService.deleteDoctorByID(id);
    }

    @DeleteMapping("/delete-doctor-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDoctorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        doctorService.deleteDoctorByFirstNameAndLastName(firstName, lastName);
    }
}
