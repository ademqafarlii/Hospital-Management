package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.DoctorPageResponse;
import org.adem.hospitalmanagement.dto.request.DoctorRequest;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;
import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.exception.DoctorNotFoundException;
import org.adem.hospitalmanagement.mapper.DoctorMapper;
import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.repository.DoctorRepository;
import org.adem.hospitalmanagement.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }


    @Override
    public void addDoctor(DoctorRequest doctorRequest) {
        doctorRepository.save(doctorMapper.toDoctorEntity(doctorRequest));
    }

    @Override
    public void updateDoctorByID(DoctorRequest doctorRequest, Integer id) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        existingDoctor.get().setEmail(doctorRequest.getEmail());
        existingDoctor.get().setFirstName(doctorRequest.getFirstName());
        existingDoctor.get().setLastName(doctorRequest.getLastName());
        existingDoctor.get().setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.get().setDepartment(doctorRequest.getDepartment());
        existingDoctor.get().setPhoneNumber(doctorRequest.getPhoneNumber());
        existingDoctor.get().setYearsOfExperience(doctorRequest.getYearsOfExperience());

        doctorRepository.save(existingDoctor.get());
    }

    @Override
    public void updateDoctorByFirstNameAndLastName(DoctorRequest doctorRequest, String firstName, String lastName) {
        Optional<Doctor> existingDoctor = doctorRepository.findByFirstNameAndLastName(firstName,lastName);
        if (existingDoctor.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found");
        }
        existingDoctor.get().setEmail(doctorRequest.getEmail());
        existingDoctor.get().setFirstName(doctorRequest.getFirstName());
        existingDoctor.get().setLastName(doctorRequest.getLastName());
        existingDoctor.get().setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.get().setDepartment(doctorRequest.getDepartment());
        existingDoctor.get().setPhoneNumber(doctorRequest.getPhoneNumber());
        existingDoctor.get().setYearsOfExperience(doctorRequest.getYearsOfExperience());

        doctorRepository.save(existingDoctor.get());
    }


    @Override
    public DoctorPageResponse getAllDoctors(Integer page, Integer count) {
        Page<Doctor> doctorPage = doctorRepository.findAll(PageRequest.of(page, count));
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        return new DoctorPageResponse(
                doctorPage.getContent().stream().map(doctorMapper::toDoctorResponse).collect(Collectors.toList()),
                doctorPage.getTotalPages(),
                doctorPage.getTotalElements(),
                doctorPage.hasNext()
        );
    }

    @Override
    public DoctorPageResponse getDoctorsBySpecialization(Specialization specialization, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Doctor> doctorPage = doctorRepository.findBySpecialization(specialization, pageable);
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        return new DoctorPageResponse(
                doctorPage.getContent().stream().map(doctorMapper::toDoctorResponse).collect(Collectors.toList()),
                doctorPage.getTotalPages(),
                doctorPage.getTotalElements(),
                doctorPage.hasNext()
        );
    }

    @Override
    public DoctorPageResponse getDoctorsByDepartment(String department, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Doctor> doctorPage = doctorRepository.findByDepartment(department, pageable);
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }
        return new DoctorPageResponse(
                doctorPage.getContent().stream().map(doctorMapper::toDoctorResponse).collect(Collectors.toList()),
                doctorPage.getTotalPages(),
                doctorPage.getTotalElements(),
                doctorPage.hasNext()
        );
    }

    @Override
    public DoctorPageResponse getAllDoctorsOrderByAge(Integer page, Integer count) {
        Page<Doctor> doctorPage = doctorRepository.findAllDoctorsOrderByAge(PageRequest.of(page,count));
        if (doctorPage.isEmpty()){
            throw new DoctorNotFoundException("Doctor not found");
        }
        return new DoctorPageResponse(
                doctorPage.getContent().stream().map(doctorMapper::toDoctorResponse).collect(Collectors.toList()),
                doctorPage.getTotalPages(),
                doctorPage.getTotalElements(),
                doctorPage.hasNext()
        );
    }

    @Override
    public DoctorResponse getDoctorByID(Integer id) {
        return doctorRepository.findById(id)
                .stream()
                .map(doctorMapper::toDoctorResponse)
                .findFirst()
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
    }


    @Override
    public DoctorResponse getDoctorByFirstNameAndLastName(String firstName, String lastName) {
        return doctorRepository.findByFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(doctorMapper::toDoctorResponse)
                .findFirst()
                .orElseThrow(()->new DoctorNotFoundException("Doctor not found"));
    }

    @Override
    public void deleteDoctorByID(Integer id) {
        if (doctorRepository.findById(id).isEmpty()){
            throw new DoctorNotFoundException("Doctor not found");
        }
        doctorRepository.deleteById(id);
    }

    @Override
    public void deleteDoctorByFirstNameAndLastName(String firstName, String lastName) {
        if (doctorRepository.findByFirstNameAndLastName(firstName,lastName).isEmpty()){
            throw new DoctorNotFoundException("Doctor not found");
        }
        doctorRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }
}
