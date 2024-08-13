package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.StaffPageResponse;
import org.adem.hospitalmanagement.dto.request.StaffRequest;
import org.adem.hospitalmanagement.dto.response.StaffResponse;
import org.adem.hospitalmanagement.enums.RoleEnum;
import org.adem.hospitalmanagement.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hospital/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/add-staff-member")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addStaffMember(@RequestBody @Valid StaffRequest staffRequest) {
        staffService.addStaffMember(staffRequest);
    }

    @PatchMapping("/update-staff-member-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateStaffMemberByID(@RequestBody @Valid StaffRequest staffRequest, @PathVariable Integer id) {
        staffService.updateStaffMemberByID(staffRequest, id);
    }

    @PatchMapping("/update-staff-member-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateStaffMemberByFirstNameAndLastName(
            @RequestBody @Valid StaffRequest staffRequest, @RequestParam String firstName, @RequestParam String lastName) {
        staffService.updateStaffMemberByFirstNameAndLastName(staffRequest, firstName, lastName);
    }

    @GetMapping("/get-all-staff-members")
    @ResponseStatus(HttpStatus.OK)
    public StaffPageResponse getAllStaffMembers(@RequestParam Integer page,@RequestParam Integer count) {
        return staffService.getAllStaffMembers(page,count);
    }

    @GetMapping("/get-staff-members-by-role")
    @ResponseStatus(HttpStatus.OK)
    public StaffPageResponse getStaffMembersByRole(@RequestParam RoleEnum roleEnum, @RequestParam Integer page, @RequestParam Integer count) {
        return staffService.getStaffMembersByRole(roleEnum, page, count);
    }

    @GetMapping("/get-staff-member-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StaffResponse getStaffMemberByID(@PathVariable Integer id) {
        return staffService.getStaffMemberByID(id);
    }

    @GetMapping("/get-staff-member-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public StaffResponse getStaffMemberByFirstNamAndLastName(@RequestParam String firstName,@RequestParam String lastName) {
        return staffService.getStaffMemberByFirstNamAndLastName(firstName,lastName);
    }

    @DeleteMapping("/delete-staff-member-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteStaffMemberByID(@PathVariable Integer id) {
        staffService.deleteStaffMemberByID(id);
    }

    @DeleteMapping("/delete-staff-member-by-firstname-and-lastname")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteStaffMemberByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName) {
        staffService.deleteStaffMemberByFirstNameAndLastName(firstName,lastName);
    }

}
