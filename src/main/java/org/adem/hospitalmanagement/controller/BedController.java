package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.BedPageResponse;
import org.adem.hospitalmanagement.dto.request.BedRequest;
import org.adem.hospitalmanagement.dto.response.BedResponse;
import org.adem.hospitalmanagement.service.BedService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital/bed")
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }


    @PostMapping("/add-bed")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addBed(@RequestBody BedRequest bedRequest) {
        bedService.addBed(bedRequest);
    }

    @PatchMapping("/update-bed-by-bed-number/{bedNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateBedByBedNumber(@RequestBody BedRequest bedRequest, @PathVariable Integer bedNumber) {
        bedService.updateBedByBedNumber(bedRequest, bedNumber);
    }

    @GetMapping("/get-all-beds")
    @ResponseStatus(HttpStatus.OK)
    public BedPageResponse getAllBeds(@RequestParam Integer page, @RequestParam Integer count) {
        return bedService.getAllBeds(page, count);
    }

    @GetMapping("/get-all-available-beds")
    @ResponseStatus(HttpStatus.OK)
    public BedPageResponse getAllAvailableBeds(@RequestParam Integer page, @RequestParam Integer count) {
        return bedService.getAllAvailableBeds(page, count);
    }

    @GetMapping("/get-bed-by-bed-number/{bedNumber}")
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByBedNumber(@PathVariable Integer bedNumber) {
        return bedService.getBedByBedNumber(bedNumber);
    }

    @GetMapping("/get-bed-by-patient-id/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByPatientId(@PathVariable Integer patientId) {
        return bedService.getBedByPatientId(patientId);
    }

    @GetMapping("get-bed-by-patient-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByPatientFirstnameAndLastname(@RequestParam String firstname,@RequestParam String lastname) {
        return bedService.getBedByPatientFirstnameAndLastname(firstname, lastname);
    }

    @PostMapping("/bed-is-available-or-not/{bedNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean isAvailableOrNot(@PathVariable Integer bedNumber) {
        return bedService.isAvailableOrNot(bedNumber);
    }

    @DeleteMapping("/delete-bed-by-bed-number/{bedNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteBedByBedNumber(@PathVariable Integer bedNumber) {
        bedService.deleteBedByBedNumber(bedNumber);
    }
}
