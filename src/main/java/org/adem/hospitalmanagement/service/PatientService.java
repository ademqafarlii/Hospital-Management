package org.adem.hospitalmanagement.service;


import org.adem.hospitalmanagement.dto.page.PatientPageResponse;
import org.adem.hospitalmanagement.dto.request.PatientRequest;
import org.adem.hospitalmanagement.dto.response.PatientResponse;

public interface PatientService {

    void addPatient(PatientRequest patientRequest);

    void updatePatientByID(PatientRequest patientRequest, Integer id);

    void updatePatientByFirstNameAndLastName(PatientRequest patientRequest, String firstName, String lastName);

    PatientPageResponse getAllPatients(Integer page, Integer count);

    PatientResponse getPatientByID(Integer id);

    PatientResponse getPatientByFirstNameAndLastName(String firstName, String lastName);

    void deletePatientByID(Integer id);

    void deletePatientByFirstNameAndLastName(String firstName, String lastName);
}
