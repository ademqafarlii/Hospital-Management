package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.DepartmentPageResponse;
import org.adem.hospitalmanagement.dto.request.DepartmentRequest;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;

public interface DepartmentService {
    void addDepartment(DepartmentRequest departmentRequest);
    void updateDepartmentByID(DepartmentRequest departmentRequest,Integer id);
    DepartmentPageResponse getAllDepartments(Integer page, Integer count);
    DepartmentResponse getDepartmentByID(Integer id);
    void deleteDepartmentByID(Integer id);
}
