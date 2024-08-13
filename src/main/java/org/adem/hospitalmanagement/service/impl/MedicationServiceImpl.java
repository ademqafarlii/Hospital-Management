package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.MedicationPageResponse;
import org.adem.hospitalmanagement.dto.request.MedicationRequest;
import org.adem.hospitalmanagement.dto.response.MedicationResponse;
import org.adem.hospitalmanagement.exception.MedicationNotFoundException;
import org.adem.hospitalmanagement.mapper.MedicationMapper;
import org.adem.hospitalmanagement.model.Medication;
import org.adem.hospitalmanagement.repository.MedicationRepository;
import org.adem.hospitalmanagement.service.MedicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    public MedicationServiceImpl(MedicationRepository medicationRepository, MedicationMapper medicationMapper) {
        this.medicationRepository = medicationRepository;
        this.medicationMapper = medicationMapper;
    }

    @Override
    public void addMedication(MedicationRequest medicationRequest) {
        medicationRepository.save(medicationMapper.toMedicationEntity(medicationRequest));
    }

    @Override
    public void updateMedicationById(MedicationRequest medicationRequest, Integer id) {
        Optional<Medication> existingMedication = medicationRepository.findById(id);
        if (existingMedication.isEmpty()){
            throw new MedicationNotFoundException("Medication not found");
        }
        existingMedication.get().setName(medicationRequest.getName());
        existingMedication.get().setManufacturer(medicationRequest.getManufacturer());
        existingMedication.get().setExpiryDate(medicationRequest.getExpiryDate());

        medicationRepository.save(existingMedication.get());
    }

    @Override
    public MedicationPageResponse getAllMedications(Integer page, Integer count) {
        Page<Medication> medicationPage = medicationRepository.findAll(PageRequest.of(page,count));
        if (medicationPage.isEmpty()){
            throw new MedicationNotFoundException("Medication not found");
        }
        return new MedicationPageResponse(
                medicationPage.getContent().stream().map(medicationMapper::toMedicationResponse).collect(Collectors.toList()),
                medicationPage.getTotalPages(),
                medicationPage.getTotalElements(),
                medicationPage.hasNext()
        );
    }

    @Override
    public MedicationResponse getMedicationByID(Integer id) {
        return medicationRepository.findById(id)
                .stream()
                .map(medicationMapper::toMedicationResponse)
                .findFirst()
                .orElseThrow(()->new MedicationNotFoundException("Medication not found"));
    }

    @Override
    public void deleteMedicationByID(Integer id) {
        if (medicationRepository.findById(id).isEmpty()){
            throw new MedicationNotFoundException("Medication not found");
        }
        medicationRepository.deleteById(id);
    }
}
