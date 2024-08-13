package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.MedicationPageResponse;
import org.adem.hospitalmanagement.dto.request.MedicationRequest;
import org.adem.hospitalmanagement.dto.response.MedicationResponse;

public interface MedicationService {
    void addMedication(MedicationRequest medicationRequest);
    void updateMedicationById(MedicationRequest medicationRequest,Integer id);
    MedicationPageResponse getAllMedications(Integer page, Integer count);
    MedicationResponse getMedicationByID(Integer id);
    void deleteMedicationByID(Integer id);
}
