package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.model.Doctor;
import org.adem.hospitalmanagement.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {
    Optional<Prescription> findByDoctor_Id(Integer id);
    Optional<Prescription> findByPatient_Id(Integer id);
}
