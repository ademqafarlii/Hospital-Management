package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.LabTestPageResponse;
import org.adem.hospitalmanagement.dto.request.LabTestRequest;
import org.adem.hospitalmanagement.dto.response.LabTestResponse;
import org.adem.hospitalmanagement.service.LabTestService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital/laboratory")
public class LabTestController {
    private final LabTestService labTestService;

    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @PostMapping("/add-test")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addLabTest(@RequestBody @Valid LabTestRequest labTestRequest) {
        labTestService.addLabTest(labTestRequest);
    }

    @PatchMapping("/update-test-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateLabTestById(@RequestBody @Valid LabTestRequest labTestRequest, @PathVariable Integer id) {
        labTestService.updateLabTestById(labTestRequest, id);
    }

    @GetMapping("/get-all-tests")
    @ResponseStatus(HttpStatus.OK)
    public LabTestPageResponse getAllLabTests(@RequestParam Integer page, @RequestParam Integer count) {
        return labTestService.getAllLabTests(page, count);
    }

    @GetMapping("/get-tes-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LabTestResponse getLabTestById(@PathVariable Integer id) {
        return labTestService.getLabTestById(id);
    }

    @GetMapping("get-test-by-doctor-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByDoctorId(@PathVariable("id") Integer doctorId) {
        return labTestService.getLabTestsByDoctorId(doctorId);
    }

    @GetMapping("get-test-by-patient-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByPatientId(@PathVariable Integer id) {
        return labTestService.getLabTestsByPatientId(id);
    }

    @GetMapping("get-test-by-doctor-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(
            @RequestParam String firstname, @RequestParam String lastname) {
        return labTestService.getLabTestsByDoctorFirstnameAndLastname(firstname, lastname);
    }

    @GetMapping("/get-test-by-patient-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(
            @RequestParam String firstname, @RequestParam String lastname) {
        return labTestService.getLabTestsByPatientFirstnameAndLastname(firstname, lastname);
    }

    @DeleteMapping("/delete-test-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteLabTestByID(@PathVariable Integer id) {
        labTestService.deleteLabTestByID(id);
    }
}
