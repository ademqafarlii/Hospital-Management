package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.DepartmentPageResponse;
import org.adem.hospitalmanagement.dto.request.DepartmentRequest;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;
import org.adem.hospitalmanagement.exception.DepartmentNotFoundException;
import org.adem.hospitalmanagement.mapper.DepartmentMapper;
import org.adem.hospitalmanagement.mapper.PatientMapper;
import org.adem.hospitalmanagement.model.Department;
import org.adem.hospitalmanagement.repository.DepartmentRepository;
import org.adem.hospitalmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        departmentRepository.save(departmentMapper.toDepartmentEntity(departmentRequest));
    }

    @Override
    public void updateDepartmentByID(DepartmentRequest departmentRequest, Integer id) {
        Optional<Department> existingDepartment= departmentRepository.findById(id);
        if (existingDepartment.isEmpty()){
            throw new DepartmentNotFoundException("Department not found");
        }
        existingDepartment.get().setHeadOfDepartment(departmentRequest.getHeadOfDepartment());
        existingDepartment.get().setName(departmentRequest.getName());

        departmentRepository.save(existingDepartment.get());
    }

    @Override
    public DepartmentPageResponse getAllDepartments(Integer page, Integer count) {
        Page<Department> departmentPage = departmentRepository.findAll(PageRequest.of(page,count));
        if (departmentPage.isEmpty()){
            throw new DepartmentNotFoundException("Department not found");
        }
        return new DepartmentPageResponse(
                departmentPage.getContent().stream().map(departmentMapper::toDepartmentResponse).collect(Collectors.toList()),
                departmentPage.getTotalPages(),
                departmentPage.getTotalElements(),
                departmentPage.hasNext()
        );
    }

    @Override
    public DepartmentResponse getDepartmentByID(Integer id) {
       return departmentRepository.findById(id)
               .stream()
               .map(departmentMapper::toDepartmentResponse)
               .findFirst()
               .orElseThrow(()->new DepartmentNotFoundException("Department not found"));
    }

    @Override
    public void deleteDepartmentByID(Integer id) {
        if (departmentRepository.findById(id).isEmpty()){
            throw new DepartmentNotFoundException("Department not found");
        }
        departmentRepository.deleteById(id);
    }
}
