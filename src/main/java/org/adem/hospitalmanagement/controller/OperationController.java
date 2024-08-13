package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.OperationPageResponse;
import org.adem.hospitalmanagement.dto.request.OperationRequest;
import org.adem.hospitalmanagement.dto.response.OperationResponse;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.service.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/add-operation")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addOperation(@RequestBody @Valid OperationRequest operationRequest) {
        operationService.addOperation(operationRequest);
    }

    @PatchMapping("/update-operation-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateOperationById(@RequestBody @Valid OperationRequest operationRequest, @PathVariable Integer id) {
        operationService.updateOperationById(operationRequest, id);
    }


    @GetMapping("/get-all-operations")
    @ResponseStatus(HttpStatus.OK)
    public OperationPageResponse getAllOperations(@RequestParam Integer page, @RequestParam Integer count) {
        return operationService.getAllOperations(page, count);
    }

    @GetMapping("/get-operation-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OperationResponse getOperationByID(@PathVariable Integer id) {
        return operationService.getOperationByID(id);
    }

    @GetMapping("/get-operation-by-doctor-id/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByDoctorId(@PathVariable Integer doctorId) {
        return operationService.getOperationByDoctorId(doctorId);
    }

    @GetMapping("/get-operation-by-doctor-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByDoctorFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return operationService.getOperationByDoctorFirstnameAndLastname(firstname, lastname);
    }

    @GetMapping("/get-operation-by-patient-id/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByPatientId(@PathVariable Integer patientId) {
        return operationService.getOperationByPatientId(patientId);
    }

    @GetMapping("/get-operation-by-patient-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByPatientFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return operationService.getOperationByPatientFirstnameAndLastname(firstname, lastname);
    }

    @DeleteMapping("/delete-operation-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteOperationById(@PathVariable Integer id) {
        operationService.deleteOperationById(id);
    }

    @GetMapping("/get-status-of-operation-by-id/{id}")
    public Status getStatusOfOperationById(@PathVariable Integer id) {
        return operationService.getStatusOfOperationById(id);
    }
}
