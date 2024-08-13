package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.BedPageResponse;
import org.adem.hospitalmanagement.dto.request.BedRequest;
import org.adem.hospitalmanagement.dto.response.BedResponse;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.exception.BedNotFoundException;
import org.adem.hospitalmanagement.exception.NoBedAvailableException;
import org.adem.hospitalmanagement.mapper.BedMapper;
import org.adem.hospitalmanagement.model.Bed;
import org.adem.hospitalmanagement.repository.BedRepository;
import org.adem.hospitalmanagement.service.BedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BedServiceImpl implements BedService {
    private final BedRepository bedRepository;
    private final BedMapper bedMapper;

    public BedServiceImpl(BedRepository bedRepository, BedMapper bedMapper) {
        this.bedRepository = bedRepository;
        this.bedMapper = bedMapper;
    }

    @Override
    public void addBed(BedRequest bedRequest) {
        bedRepository.save(bedMapper.toBedEntity(bedRequest));
    }

    @Override
    public void updateBedByBedNumber(BedRequest bedRequest, Integer bedNumber) {
        Optional<Bed> existingBed = bedRepository.findById(bedNumber);
        if (existingBed.isEmpty()){
            throw new BedNotFoundException("Bed not found");
        }
        existingBed.get().setRoom(bedRequest.getRoom());
        existingBed.get().setPatient(bedRequest.getPatient());
        existingBed.get().setStatus(bedRequest.getStatus());
        bedRepository.save(existingBed.get());
    }

    @Override
    public BedPageResponse getAllBeds(Integer page, Integer count) {
        Page<Bed> bedPage = bedRepository.findAll(PageRequest.of(page,count));
        if (bedPage.isEmpty()){
            throw new BedNotFoundException("Bed not found");
        }
        return new BedPageResponse(
                bedPage.getContent().stream().map(bedMapper::toBedResponse).collect(Collectors.toList()),
                bedPage.getTotalPages(),
                bedPage.getTotalElements(),
                bedPage.hasNext()
        );
    }

    @Override
    public BedPageResponse getAllAvailableBeds(Integer page, Integer count) {
        Page<Bed> bedPage = bedRepository.findAll(PageRequest.of(page, count));
        List<Bed> availableBeds = bedPage.getContent().stream()
                .filter(bed -> bed.getStatus() == Status.AVAILABLE)
                .toList();

        if (availableBeds.isEmpty()) {
            throw new NoBedAvailableException("No bed available");
        }

        return new BedPageResponse(
                availableBeds.stream().map(bedMapper::toBedResponse).collect(Collectors.toList()),
                bedPage.getTotalPages(),
                bedPage.getTotalElements(),
                bedPage.hasNext()
        );
    }

    @Override
    public BedResponse getBedByBedNumber(Integer bedNumber) {
        return bedRepository.findById(bedNumber)
                .stream()
                .map(bedMapper::toBedResponse)
                .findFirst()
                .orElseThrow(()->new BedNotFoundException("Bed not found"));
    }

    @Override
    public BedResponse getBedByPatientId(Integer patientId) {
        return bedRepository.findByPatient_Id(patientId)
                .stream()
                .map(bedMapper::toBedResponse)
                .findFirst()
                .orElseThrow(()->new BedNotFoundException("Bed not found"));
    }

    @Override
    public BedResponse getBedByPatientFirstnameAndLastname(String firstname, String lastname) {
        return bedRepository.findByPatient_FirstNameAndPatient_LastName(firstname,lastname)
                .stream()
                .map(bedMapper::toBedResponse)
                .findFirst()
                .orElseThrow(()->new BedNotFoundException("Bed not found"));
    }

    @Override
    public boolean isAvailableOrNot(Integer bedNumber) {
        Optional<Bed> bed = bedRepository.findById(bedNumber);
        if (bed.isEmpty()){
            throw new BedNotFoundException("Bed not found");
        }
       return bed.get().getStatus()==Status.AVAILABLE;
    }

    @Override
    public void deleteBedByBedNumber(Integer bedNumber) {
        Optional<Bed> bed = bedRepository.findById(bedNumber);
        if (bed.isEmpty()){
            throw new BedNotFoundException("Bed not found");
        }
        bedRepository.deleteById(bedNumber);

    }
}
