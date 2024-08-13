package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.enums.Specialization;
import org.adem.hospitalmanagement.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Page<Doctor> findBySpecialization(Specialization specialization, Pageable pageable);
    Page<Doctor> findByDepartment(String department,Pageable pageable);
    Optional<Doctor> findByFirstNameAndLastName(String firstName,String lastName);
    void deleteByFirstNameAndLastName(String firstName, String lastName);
    @Query(value = "select *from doctor order by age",nativeQuery = true)
    Page<Doctor> findAllDoctorsOrderByAge(PageRequest pageRequest);


}
