package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.StaffPageResponse;
import org.adem.hospitalmanagement.dto.request.StaffRequest;
import org.adem.hospitalmanagement.dto.response.StaffResponse;
import org.adem.hospitalmanagement.enums.RoleEnum;
import org.adem.hospitalmanagement.exception.StaffMemberNotFoundException;
import org.adem.hospitalmanagement.mapper.StaffMapper;
import org.adem.hospitalmanagement.model.Staff;
import org.adem.hospitalmanagement.repository.StaffRepository;
import org.adem.hospitalmanagement.service.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    public void addStaffMember(StaffRequest staffRequest) {
        staffRepository.save(staffMapper.toStaffEntity(staffRequest));
    }

    @Override
    public void updateStaffMemberByID(StaffRequest staffRequest, Integer id) {
        Optional<Staff> existingStaffMember = staffRepository.findById(id);
        if (existingStaffMember.isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        existingStaffMember.get().setFirstName(staffRequest.getFirstName());
        existingStaffMember.get().setLastName(staffRequest.getLastName());
        existingStaffMember.get().setAge(staffRequest.getAge());
        existingStaffMember.get().setEmail(staffRequest.getEmail());
        existingStaffMember.get().setPhoneNumber(staffRequest.getPhoneNumber());
        existingStaffMember.get().setRoleEnum(staffRequest.getRoleEnum());
        existingStaffMember.get().setDepartment(staffRequest.getDepartment());

        staffRepository.save(existingStaffMember.get());
    }

    @Override
    public void updateStaffMemberByFirstNameAndLastName(StaffRequest staffRequest, String firstName, String lastName) {
        Optional<Staff> existingStaffMember = staffRepository.findByFirstNameAndLastName(firstName,lastName);
        if (existingStaffMember.isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        existingStaffMember.get().setFirstName(staffRequest.getFirstName());
        existingStaffMember.get().setLastName(staffRequest.getLastName());
        existingStaffMember.get().setAge(staffRequest.getAge());
        existingStaffMember.get().setEmail(staffRequest.getEmail());
        existingStaffMember.get().setPhoneNumber(staffRequest.getPhoneNumber());
        existingStaffMember.get().setRoleEnum(staffRequest.getRoleEnum());
        existingStaffMember.get().setDepartment(staffRequest.getDepartment());

        staffRepository.save(existingStaffMember.get());
    }

    @Override
    public StaffPageResponse getAllStaffMembers(Integer page, Integer count) {
        Page<Staff> staffPage = staffRepository.findAll(PageRequest.of(page,count));
        if (staffPage.isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        return new StaffPageResponse(
                staffPage.getContent().stream().map(staffMapper::toStaffResponse).collect(Collectors.toList()),
                staffPage.getTotalPages(),
                staffPage.getTotalElements(),
                staffPage.hasNext()
        );
    }

    @Override
    public StaffPageResponse getStaffMembersByRole(RoleEnum roleEnum, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page,count);
        Page<Staff> staffPage = staffRepository.findByRoleEnum(roleEnum,pageable);
        if (staffPage.isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        return new StaffPageResponse(
                staffPage.getContent().stream().map(staffMapper::toStaffResponse).collect(Collectors.toList()),
                staffPage.getTotalPages(),
                staffPage.getTotalElements(),
                staffPage.hasNext()
        );
    }

    @Override
    public StaffResponse getStaffMemberByID(Integer id) {
        return staffRepository.findById(id)
                .stream()
                .map(staffMapper::toStaffResponse)
                .findFirst()
                .orElseThrow(()->new StaffMemberNotFoundException("Staff member not found"));
    }

    @Override
    public StaffResponse getStaffMemberByFirstNamAndLastName(String firstName, String lastName) {
        return staffRepository.findByFirstNameAndLastName(firstName,lastName)
                .stream()
                .map(staffMapper::toStaffResponse)
                .findFirst()
                .orElseThrow(()->new StaffMemberNotFoundException("Staff member not found"));
    }

    @Override
    public void deleteStaffMemberByID(Integer id) {
        if (staffRepository.findById(id).isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        staffRepository.deleteById(id);
    }

    @Override
    public void deleteStaffMemberByFirstNameAndLastName(String firstName, String lastName) {
        if (staffRepository.findByFirstNameAndLastName(firstName,lastName).isEmpty()){
            throw new StaffMemberNotFoundException("Staff member not found");
        }
        staffRepository.deleteByFirstNameAndLastName(firstName,lastName);
    }
}
