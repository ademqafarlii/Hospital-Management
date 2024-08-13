package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.LabTestPageResponse;
import org.adem.hospitalmanagement.dto.request.LabTestRequest;
import org.adem.hospitalmanagement.dto.response.LabTestResponse;

import java.util.List;

public interface LabTestService {
    void addLabTest(LabTestRequest labTestRequest);

    void updateLabTestById(LabTestRequest labTestRequest, Integer id);

    LabTestPageResponse getAllLabTests(Integer page, Integer count);

    LabTestResponse getLabTestById(Integer id);

    List<LabTestResponse> getLabTestsByDoctorId(Integer doctorId);

    List<LabTestResponse> getLabTestsByPatientId(Integer id);

    List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(String firstname, String lastname);

    List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(String firstname, String lastname);

    void deleteLabTestByID(Integer id);
}
