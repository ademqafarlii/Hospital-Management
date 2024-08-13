package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.PatientPageResponse;
import org.adem.hospitalmanagement.dto.request.PatientRequest;
import org.adem.hospitalmanagement.dto.response.PatientResponse;
import org.adem.hospitalmanagement.exception.PatientNotFoundException;
import org.adem.hospitalmanagement.mapper.PatientMapper;
import org.adem.hospitalmanagement.model.Patient;
import org.adem.hospitalmanagement.repository.PatientRepository;
import org.adem.hospitalmanagement.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public void addPatient(PatientRequest patientRequest) {
        patientRepository.save(patientMapper.toPatientEntity(patientRequest));
    }

    @Override
    public void updatePatientByID(PatientRequest patientRequest, Integer id) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        existingPatient.get().setFirstName(patientRequest.getFirstName());
        existingPatient.get().setLastName(patientRequest.getLastName());
        existingPatient.get().setGender(patientRequest.getGender());
        existingPatient.get().setAddress(patientRequest.getAddress());
        existingPatient.get().setDateOfBirth(patientRequest.getDateOfBirth());
        existingPatient.get().setAge(patientRequest.getAge());
        existingPatient.get().setPhoneNumber(patientRequest.getPhoneNumber());
        existingPatient.get().setEmail(patientRequest.getEmail());

        patientRepository.save(existingPatient.get());
    }

    @Override
    public void updatePatientByFirstNameAndLastName(PatientRequest patientRequest, String firstName, String lastName) {
        Optional<Patient> existingPatient = patientRepository.findByFirstNameAndLastName(firstName,lastName);
        if (existingPatient.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        existingPatient.get().setFirstName(patientRequest.getFirstName());
        existingPatient.get().setLastName(patientRequest.getLastName());
        existingPatient.get().setGender(patientRequest.getGender());
        existingPatient.get().setAddress(patientRequest.getAddress());
        existingPatient.get().setDateOfBirth(patientRequest.getDateOfBirth());
        existingPatient.get().setAge(patientRequest.getAge());
        existingPatient.get().setPhoneNumber(patientRequest.getPhoneNumber());
        existingPatient.get().setEmail(patientRequest.getEmail());

        patientRepository.save(existingPatient.get());
    }

    @Override
    public PatientPageResponse getAllPatients(Integer page, Integer count) {
        Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(page,count));
        if (patientPage.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        return new PatientPageResponse(
                patientPage.getContent().stream().map(patientMapper::toPatientResponse).collect(Collectors.toList()),
                patientPage.getTotalPages(),
                patientPage.getTotalElements(),
                patientPage.hasNext()
        );
    }

    @Override
    public PatientResponse getPatientByID(Integer id) {
        return patientRepository.findById(id)
                .stream()
                .map(patientMapper::toPatientResponse)
                .findFirst()
                .orElseThrow(()->new PatientNotFoundException("Patient not found"));
    }

    @Override
    public PatientResponse getPatientByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName,lastName)
                .stream()
                .map(patientMapper::toPatientResponse)
                .findFirst()
                .orElseThrow(()->new PatientNotFoundException("Patient not found"));
    }

    @Override
    public void deletePatientByID(Integer id) {
        if (patientRepository.findById(id).isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public void deletePatientByFirstNameAndLastName(String firstName, String lastName) {
        if (patientRepository.findByFirstNameAndLastName(firstName,lastName).isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        patientRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }
}
