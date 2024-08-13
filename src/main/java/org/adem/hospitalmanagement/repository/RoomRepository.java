package org.adem.hospitalmanagement.repository;

import org.adem.hospitalmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByDoctor_Id(Integer doctorId);
    Optional<Room> findByPatient_Id(Integer patientId);
    List<Room> findByDoctor_FirstNameAndDoctor_LastName(String firstname, String lastname);
    Optional<Room> findByPatient_FirstNameAndPatient_LastName(String firstname,String lastname);
}
