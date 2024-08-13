package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.LabTestPageResponse;
import org.adem.hospitalmanagement.dto.request.LabTestRequest;
import org.adem.hospitalmanagement.dto.response.LabTestResponse;
import org.adem.hospitalmanagement.exception.LabTestNotFoundException;
import org.adem.hospitalmanagement.mapper.LabTestMapper;
import org.adem.hospitalmanagement.model.LabTest;
import org.adem.hospitalmanagement.repository.LabTestRepository;
import org.adem.hospitalmanagement.service.LabTestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabTestServiceImpl implements LabTestService {
    private final LabTestRepository labTestRepository;
    private final LabTestMapper labTestMapper;

    public LabTestServiceImpl(LabTestRepository labTestRepository, LabTestMapper labTestMapper) {
        this.labTestRepository = labTestRepository;
        this.labTestMapper = labTestMapper;
    }

    @Override
    public void addLabTest(LabTestRequest labTestRequest) {
        labTestRepository.save(labTestMapper.toLabTestEntity(labTestRequest));
    }

    @Override
    public void updateLabTestById(LabTestRequest labTestRequest, Integer id) {
        Optional<LabTest> existingLabTest = labTestRepository.findById(id);
        if (existingLabTest.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        existingLabTest.get().setTestName(labTestRequest.getTestName());
        existingLabTest.get().setTestDate(labTestRequest.getTestDate());
        existingLabTest.get().setPatient(labTestRequest.getPatient());
        existingLabTest.get().setDoctor(labTestRequest.getDoctor());
        existingLabTest.get().setResult(labTestRequest.getResult());
        existingLabTest.get().setDescription(labTestRequest.getDescription());
        labTestRepository.save(existingLabTest.get());
    }

    @Override
    public LabTestPageResponse getAllLabTests(Integer page, Integer count) {
        Page<LabTest> labTestPage = labTestRepository.findAll(PageRequest.of(page, count));
        if (labTestPage.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        return new LabTestPageResponse(
                labTestPage.getContent().stream().map(labTestMapper::toLabTestResponse).collect(Collectors.toList()),
                labTestPage.getTotalPages(),
                labTestPage.getTotalElements(),
                labTestPage.hasNext()
        );
    }

    @Override
    public LabTestResponse getLabTestById(Integer id) {
        return labTestRepository.findById(id)
                .stream()
                .map(labTestMapper::toLabTestResponse)
                .findFirst()
                .orElseThrow(() -> new LabTestNotFoundException("Lab test not found"));
    }

    @Override
    public List<LabTestResponse> getLabTestsByDoctorId(Integer doctorId) {
        List<LabTest> labTests = labTestRepository.findByDoctor_Id(doctorId);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        return labTests
                .stream()
                .map(labTestMapper::toLabTestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabTestResponse> getLabTestsByPatientId(Integer id) {
        List<LabTest> labTests = labTestRepository.findByPatient_Id(id);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        return labTests
                .stream()
                .map(labTestMapper::toLabTestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(String firstname, String lastname){
        List<LabTest> labTests = labTestRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname,lastname);
        if (labTests.isEmpty()){
            throw new LabTestNotFoundException("Lab test not found");
        }
        return labTests
                .stream()
                .map(labTestMapper::toLabTestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(String firstname, String lastname) {
        List<LabTest> labTests = labTestRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        return labTests
                .stream()
                .map(labTestMapper::toLabTestResponse)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteLabTestByID(Integer id) {
        Optional<LabTest> labTest = labTestRepository.findById(id);
        if (labTest.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        }
        labTestRepository.deleteById(id);
    }
}
