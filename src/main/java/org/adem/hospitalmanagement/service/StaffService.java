package org.adem.hospitalmanagement.service;


import org.adem.hospitalmanagement.dto.page.StaffPageResponse;
import org.adem.hospitalmanagement.dto.request.StaffRequest;
import org.adem.hospitalmanagement.dto.response.StaffResponse;
import org.adem.hospitalmanagement.enums.RoleEnum;

public interface StaffService {

    void addStaffMember(StaffRequest staffRequest);
    void updateStaffMemberByID(StaffRequest staffRequest,Integer id);
    void updateStaffMemberByFirstNameAndLastName(StaffRequest staffRequest,String firstName, String lastName);
    StaffPageResponse getAllStaffMembers(Integer page, Integer count);
    StaffPageResponse getStaffMembersByRole(RoleEnum roleEnum, Integer page, Integer count);
    StaffResponse getStaffMemberByID(Integer id);
    StaffResponse getStaffMemberByFirstNamAndLastName(String firstName, String lastName);
    void deleteStaffMemberByID(Integer id);
    void deleteStaffMemberByFirstNameAndLastName(String firstName, String lastName);
}
