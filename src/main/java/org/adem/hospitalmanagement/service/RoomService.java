package org.adem.hospitalmanagement.service;

import org.adem.hospitalmanagement.dto.page.RoomPageResponse;
import org.adem.hospitalmanagement.dto.request.RoomRequest;
import org.adem.hospitalmanagement.dto.response.RoomResponse;
import org.adem.hospitalmanagement.enums.Status;

import java.util.List;

public interface RoomService {
    void addRoom(RoomRequest roomRequest);
    void updateRoomByRoomNumber(RoomRequest roomRequest,Integer roomNumber);
    RoomPageResponse getAllRooms(Integer page, Integer count);
    RoomResponse getRoomByRoomNumber(Integer roomNumber);
    List<RoomResponse> getRoomsByDoctorId(Integer doctorId);
    List<RoomResponse> getRoomsByDoctorFirstnameAndDoctorLastname(String firstname, String lastname);
    RoomResponse getRoomByPatientId(Integer patientId);
    RoomResponse getRoomByPatientFirstnameAndPatientLastname(String firstname, String lastname);
    void deleteRoomByRoomNumber(Integer id);
    boolean isAvailable(Status status);
}
