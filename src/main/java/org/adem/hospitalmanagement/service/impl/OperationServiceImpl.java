package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.OperationPageResponse;
import org.adem.hospitalmanagement.dto.request.OperationRequest;
import org.adem.hospitalmanagement.dto.response.OperationResponse;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.exception.OperationNotFoundException;
import org.adem.hospitalmanagement.mapper.OperationMapper;
import org.adem.hospitalmanagement.model.Operation;
import org.adem.hospitalmanagement.repository.OperationRepository;
import org.adem.hospitalmanagement.service.OperationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;

    public OperationServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper) {
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
    }

    @Override
    public void addOperation(OperationRequest operationRequest) {
        operationRepository.save(operationMapper.toOperationEntity(operationRequest));
    }

    @Override
    public void updateOperationById(OperationRequest operationRequest, Integer id) {
        Optional<Operation> existingOperation = operationRepository.findById(id);
        if (existingOperation.isEmpty()){
            throw new OperationNotFoundException("Operation not found");
        }
        existingOperation.get().setOperationName(operationRequest.getOperationName());
        existingOperation.get().setDescription(operationRequest.getDescription());
        existingOperation.get().setDoctor(operationRequest.getDoctor());
        existingOperation.get().setPatient(operationRequest.getPatient());
        existingOperation.get().setStatus(operationRequest.getStatus());
        existingOperation.get().setOperationDate(operationRequest.getOperationDate());
        operationRepository.save(existingOperation.get());
    }

    @Override
    public OperationPageResponse getAllOperations(Integer page, Integer count) {
        Page<Operation> operationPage = operationRepository.findAll(PageRequest.of(page,count));
        if (operationPage.isEmpty()){
            throw new OperationNotFoundException("Operation not found");
        }
        return new OperationPageResponse(
                operationPage.getContent().stream().map(operationMapper::toOperationResponse).collect(Collectors.toList()),
                operationPage.getTotalPages(),
                operationPage.getTotalElements(),
                operationPage.hasNext()
        );
    }

    @Override
    public OperationResponse getOperationByID(Integer id) {
        return operationRepository.findById(id)
                .stream()
                .map(operationMapper::toOperationResponse)
                .findFirst()
                .orElseThrow(()->new OperationNotFoundException("Operation not found"));
    }

    @Override
    public List<OperationResponse> getOperationByDoctorId(Integer doctorId) {
        return operationRepository.findByDoctor_Id(doctorId)
                .stream()
                .map(operationMapper::toOperationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<OperationResponse> getOperationByDoctorFirstnameAndLastname(String firstname, String lastname) {
        return operationRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname, lastname)
                .stream()
                .map(operationMapper::toOperationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<OperationResponse> getOperationByPatientId(Integer patientId) {
        return operationRepository.findByPatient_Id(patientId)
                .stream()
                .map(operationMapper::toOperationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<OperationResponse> getOperationByPatientFirstnameAndLastname(String firstname, String lastname) {
        return operationRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname)
                .stream()
                .map(operationMapper::toOperationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOperationById(Integer id) {
        Optional<Operation> operation = operationRepository.findById(id);
        if (operation.isEmpty()){
            throw new OperationNotFoundException("Operation not found");
        }
        operationRepository.deleteById(id);
    }

    @Override
    public Status getStatusOfOperationById(Integer id) {
        Optional<Operation> operation = operationRepository.findById(id);
        if (operation.isEmpty()){
            throw new OperationNotFoundException("Operation not found");
        }
        return operation.get().getStatus();
    }
}
