package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.DepartmentPageResponse;
import org.adem.hospitalmanagement.dto.request.DepartmentRequest;
import org.adem.hospitalmanagement.dto.response.DepartmentResponse;
import org.adem.hospitalmanagement.model.Department;
import org.adem.hospitalmanagement.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("hospital/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add-department")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addDepartment(@RequestBody @Valid DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
    }

    @PatchMapping("/update-department-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDepartmentByID(@RequestBody DepartmentRequest departmentRequest, @PathVariable Integer id) {
        departmentService.updateDepartmentByID(departmentRequest, id);
    }

    @GetMapping("/get-all-departments")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DepartmentPageResponse getAllDepartments(@RequestParam Integer page, @RequestParam Integer count) {
        return departmentService.getAllDepartments(page, count);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get-department-by-id/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DepartmentResponse getDepartmentByID(@PathVariable Integer id) {
        return departmentService.getDepartmentByID(id);
    }

    @DeleteMapping("/delete-department-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDepartmentByID(@PathVariable Integer id) {
        departmentService.deleteDepartmentByID(id);
    }
}
