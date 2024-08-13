package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.BedPageResponse;
import org.adem.hospitalmanagement.dto.request.BedRequest;
import org.adem.hospitalmanagement.dto.response.BedResponse;

public interface BedService {
    void addBed(BedRequest bedRequest);
    void updateBedByBedNumber(BedRequest bedRequest,Integer bedNumber);
    BedPageResponse getAllBeds(Integer page, Integer count);
    BedPageResponse getAllAvailableBeds(Integer page, Integer count);
    BedResponse getBedByBedNumber(Integer bedNumber);
    BedResponse getBedByPatientId(Integer patientId);
    BedResponse getBedByPatientFirstnameAndLastname(String firstname, String lastname);
    boolean isAvailableOrNot(Integer bedNumber);
    void deleteBedByBedNumber(Integer bedNumber);
}
