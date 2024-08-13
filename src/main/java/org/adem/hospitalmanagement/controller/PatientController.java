package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.PatientPageResponse;
import org.adem.hospitalmanagement.dto.request.PatientRequest;
import org.adem.hospitalmanagement.dto.response.PatientResponse;
import org.adem.hospitalmanagement.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addPatient(@RequestBody @Valid PatientRequest patientRequest) {
        patientService.addPatient(patientRequest);
    }

    @PatchMapping("/update-patient-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePatientByID(@RequestBody @Valid PatientRequest patientRequest, @PathVariable Integer id) {
        patientService.updatePatientByID(patientRequest, id);
    }

    @PatchMapping("/update-patient-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePatientByFirstNameAndLastName(
            @RequestBody @Valid PatientRequest patientRequest, @RequestParam String firstName, @RequestParam String lastName) {
        patientService.updatePatientByFirstNameAndLastName(patientRequest, firstName, lastName);
    }

    @GetMapping("/get-all-patients")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientPageResponse getAllPatients(@RequestParam Integer page, @RequestParam Integer count) {
        return patientService.getAllPatients(page, count);
    }

    @GetMapping("get-patient-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientResponse getPatientByID(@PathVariable Integer id) {
        return patientService.getPatientByID(id);
    }


    @GetMapping("/get-patient-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientResponse getPatientByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return patientService.getPatientByFirstNameAndLastName(firstName, lastName);
    }

    @DeleteMapping("/delete-patient-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePatientByID(@PathVariable Integer id) {
        patientService.deletePatientByID(id);
    }


    @DeleteMapping("/delete-patient-by-id")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePatientByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        patientService.deletePatientByFirstNameAndLastName(firstName, lastName);
    }
}
