package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.MedicationPageResponse;
import org.adem.hospitalmanagement.dto.request.MedicationRequest;
import org.adem.hospitalmanagement.dto.response.MedicationResponse;
import org.adem.hospitalmanagement.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hospital/medication")
public class MedicationController {
    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/add-medication")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addMedication(@RequestBody @Valid MedicationRequest medicationRequest) {
        medicationService.addMedication(medicationRequest);
    }

    @PatchMapping("/update-medication-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateMedicationById(@RequestBody @Valid MedicationRequest medicationRequest, @PathVariable Integer id) {
        medicationService.updateMedicationById(medicationRequest, id);
    }

    @GetMapping("/get-all-medications")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MedicationPageResponse getAllMedications(@RequestParam Integer page, @RequestParam Integer count) {
        return medicationService.getAllMedications(page,count);
    }

    @GetMapping("/get-medication-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MedicationResponse getMedicationByID(@PathVariable Integer id) {
        return medicationService.getMedicationByID(id);
    }

    @DeleteMapping("/delete-medication-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteMedicationByID(@PathVariable Integer id) {
    medicationService.deleteMedicationByID(id);
    }
}
