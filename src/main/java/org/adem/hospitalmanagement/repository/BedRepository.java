package org.adem.hospitalmanagement.repository;


import org.adem.hospitalmanagement.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed,Integer> {
    Optional<Bed> findByPatient_Id(Integer id);
    Optional<Bed> findByPatient_FirstNameAndPatient_LastName(String firstname, String lastname);
}
