package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.PrescriptionPageResponse;
import org.adem.hospitalmanagement.dto.request.PrescriptionRequest;
import org.adem.hospitalmanagement.dto.response.PrescriptionResponse;
import org.adem.hospitalmanagement.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/add-prescription")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addPrescription(@RequestBody PrescriptionRequest prescriptionRequest) {
        prescriptionService.addPrescription(prescriptionRequest);
    }

    @PatchMapping("/update-prescription-by-prescription-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePrescriptionByPrescriptionId(@RequestBody PrescriptionRequest prescriptionRequest, @PathVariable Integer id) {
        prescriptionService.updatePrescriptionByPrescriptionId(prescriptionRequest, id);
    }

    @GetMapping("/get-all-prescriptions")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PrescriptionPageResponse getAllPrescriptions(@RequestParam Integer page, @RequestParam Integer count) {
        return prescriptionService.getAllPrescriptions(page,count);
    }


    @GetMapping("/get-prescription-by-doctor-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PrescriptionResponse> getPrescriptionByDoctorId(@PathVariable Integer id) {
        return prescriptionService.getPrescriptionByDoctorId(id);
    }

    @GetMapping("/get-prescription-by-patient-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PrescriptionResponse> getPrescriptionByPatientId(@PathVariable Integer id) {
        return prescriptionService.getPrescriptionByPatientId(id);
    }

    @PostMapping("/validate-prescription/{prescriptionId}")
    @ResponseStatus
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Boolean validatePrescription(@PathVariable Integer prescriptionId) {
        return prescriptionService.validatePrescription(prescriptionId);
    }

    @DeleteMapping("/delete-prescription-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePrescriptionById(@PathVariable Integer id){
        prescriptionService.deletePrescriptionById(id);
    }
}
