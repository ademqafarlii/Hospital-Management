package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.OperationPageResponse;
import org.adem.hospitalmanagement.dto.request.OperationRequest;
import org.adem.hospitalmanagement.dto.response.OperationResponse;
import org.adem.hospitalmanagement.enums.Status;

import java.util.List;

public interface OperationService {
    void addOperation(OperationRequest operationRequest);
    void updateOperationById(OperationRequest operationRequest,Integer id);
    OperationPageResponse getAllOperations(Integer page, Integer count);
    OperationResponse getOperationByID(Integer id);
    List<OperationResponse> getOperationByDoctorId(Integer doctorId);
    List<OperationResponse> getOperationByDoctorFirstnameAndLastname(String firstname, String lastname);
    List<OperationResponse> getOperationByPatientId(Integer patientId);
    List<OperationResponse> getOperationByPatientFirstnameAndLastname(String firstname, String lastname);
    void deleteOperationById(Integer id);
    Status getStatusOfOperationById(Integer id);
}
