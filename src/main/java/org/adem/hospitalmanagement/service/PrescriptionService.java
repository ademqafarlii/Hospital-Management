package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.PrescriptionPageResponse;
import org.adem.hospitalmanagement.dto.request.PrescriptionRequest;
import org.adem.hospitalmanagement.dto.response.PrescriptionResponse;

import java.util.List;

public interface PrescriptionService {
    void addPrescription(PrescriptionRequest prescriptionRequest);
    void updatePrescriptionByPrescriptionId(PrescriptionRequest prescriptionRequest,Integer id);
    PrescriptionPageResponse getAllPrescriptions(Integer page,Integer count);
    List<PrescriptionResponse> getPrescriptionByDoctorId(Integer id);
    List<PrescriptionResponse> getPrescriptionByPatientId(Integer id);
    Boolean validatePrescription(Integer prescriptionId);
    void deletePrescriptionById(Integer id);

}
