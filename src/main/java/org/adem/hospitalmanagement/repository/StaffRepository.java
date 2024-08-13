package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.enums.RoleEnum;
import org.adem.hospitalmanagement.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    Optional<Staff> findByFirstNameAndLastName(String firstName, String lastName);
    Page<Staff> findByRoleEnum(RoleEnum roleEnum, Pageable pageable);
    void deleteByFirstNameAndLastName(String firstName, String lastName);
}
