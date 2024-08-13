package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.model.LabTest;
import org.adem.hospitalmanagement.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {
    List<Operation> findByPatient_FirstNameAndPatient_LastName(String firstname, String lastname);
    List<Operation> findByDoctor_FirstNameAndDoctor_LastName(String firstname, String lastname);
    List<Operation> findByPatient_Id(Integer id);
    List<Operation> findByDoctor_Id(Integer id);
}
