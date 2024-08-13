package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.PrescriptionPageResponse;
import org.adem.hospitalmanagement.dto.request.PrescriptionRequest;
import org.adem.hospitalmanagement.dto.response.PrescriptionResponse;
import org.adem.hospitalmanagement.exception.PrescriptionNotFoundException;
import org.adem.hospitalmanagement.mapper.PrescriptionMapper;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Prescription;
import org.adem.hospitalmanagement.repository.DoctorRepository;
import org.adem.hospitalmanagement.repository.PrescriptionRepository;
import org.adem.hospitalmanagement.service.PrescriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, PrescriptionMapper prescriptionMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionMapper = prescriptionMapper;
    }


    @Override
    public void addPrescription(PrescriptionRequest prescriptionRequest) {
        prescriptionRepository.save(prescriptionMapper.toPrescriptionEntity(prescriptionRequest));
    }

    @Override
    public void updatePrescriptionByPrescriptionId(PrescriptionRequest prescriptionRequest,Integer id) {
        Optional<Prescription> existingPrescription = prescriptionRepository.findById(id);
        if (existingPrescription.isEmpty()){
            throw new PrescriptionNotFoundException("Prescription not found");
        }
        existingPrescription.get().setDoctor(prescriptionRequest.getDoctor());
        existingPrescription.get().setInstructions(prescriptionRequest.getInstructions());
        existingPrescription.get().setPatient(prescriptionRequest.getPatient());
        existingPrescription.get().setLocalDateTime(prescriptionRequest.getLocalDateTime());
        existingPrescription.get().setMedication(prescriptionRequest.getMedication());
        existingPrescription.get().setValid(prescriptionRequest.isValid());

        prescriptionRepository.save(existingPrescription.get());
    }

    @Override
    public PrescriptionPageResponse getAllPrescriptions(Integer page, Integer count) {
        Page<Prescription> prescriptionPage = prescriptionRepository.findAll(PageRequest.of(page,count));
        if (prescriptionPage.isEmpty()){
            throw new PrescriptionNotFoundException("Prescription not found");
        }
        return new PrescriptionPageResponse(
                prescriptionPage.getContent().stream().map(prescriptionMapper::toPrescriptionResponse).collect(Collectors.toList()),
                prescriptionPage.getTotalPages(),
                prescriptionPage.getTotalElements(),
                prescriptionPage.hasNext()
        );
    }

    @Override
    public List<PrescriptionResponse> getPrescriptionByDoctorId(Integer id) {
        return prescriptionRepository.findByDoctor_Id(id)
                .stream()
                .map(prescriptionMapper::toPrescriptionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PrescriptionResponse> getPrescriptionByPatientId(Integer id) {
        return prescriptionRepository.findByPatient_Id(id)
                .stream()
                .map(prescriptionMapper::toPrescriptionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean validatePrescription(Integer prescriptionId) {
        Optional<Prescription> isValid = prescriptionRepository.findById(prescriptionId);
        if (isValid.isEmpty()) {
            throw new PrescriptionNotFoundException("Prescription not found");
        }
        return isValid.get().isValid();
    }

    @Override
    public void deletePrescriptionById(Integer id) {
        if (prescriptionRepository.findById(id).isEmpty()){
            throw new PrescriptionNotFoundException("Prescription not found");
        }
        prescriptionRepository.deleteById(id);
    }

}
