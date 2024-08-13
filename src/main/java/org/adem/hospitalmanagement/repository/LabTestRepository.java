package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabTestRepository extends JpaRepository<LabTest, Integer> {
    List<LabTest> findByDoctor_Id(Integer doctorId);
    List<LabTest> findByPatient_Id(Integer patientId);
    List<LabTest> findByPatient_FirstNameAndPatient_LastName(String firstname, String lastname);
    List<LabTest> findByDoctor_FirstNameAndDoctor_LastName(String firstname, String lastname);
}
