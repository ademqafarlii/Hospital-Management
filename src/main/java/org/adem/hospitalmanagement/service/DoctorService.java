package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.DoctorPageResponse;
import org.adem.hospitalmanagement.dto.request.DoctorRequest;
import org.adem.hospitalmanagement.dto.response.DoctorResponse;
import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.model.Department;

public interface DoctorService {

    void addDoctor(DoctorRequest doctorRequest);

    void updateDoctorByID(DoctorRequest doctorRequest, Integer id);

    void updateDoctorByFirstNameAndLastName(DoctorRequest doctorRequest, String firstName, String lastName);

    DoctorPageResponse getAllDoctors(Integer page, Integer count);

    DoctorPageResponse getDoctorsBySpecialization(Specialization specialization, Integer page, Integer count);

    DoctorPageResponse getDoctorsByDepartment(String department, Integer page, Integer count);

    DoctorPageResponse getAllDoctorsOrderByAge(Integer page, Integer count);

    DoctorResponse getDoctorByID(Integer id);

    DoctorResponse getDoctorByFirstNameAndLastName(String firstName, String lastName);

    void deleteDoctorByID(Integer id);

    void deleteDoctorByFirstNameAndLastName(String firstName, String lastName);
}
