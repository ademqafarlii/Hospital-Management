package org.adem.hospitalmanagement.service.impl;

import org.adem.hospitalmanagement.dto.page.RoomPageResponse;
import org.adem.hospitalmanagement.dto.request.RoomRequest;
import org.adem.hospitalmanagement.dto.response.RoomResponse;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.exception.RoomNotFoundException;
import org.adem.hospitalmanagement.mapper.RoomMapper;
import org.adem.hospitalmanagement.model.Room;
import org.adem.hospitalmanagement.repository.RoomRepository;
import org.adem.hospitalmanagement.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public void addRoom(RoomRequest roomRequest) {
        roomRepository.save(roomMapper.toRoomEntity(roomRequest));
    }

    @Override
    public void updateRoomByRoomNumber(RoomRequest roomRequest, Integer roomNumber) {
        Optional<Room> existingRoom = roomRepository.findById(roomNumber);
        if (existingRoom.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        }
        existingRoom.get().setRoomStatus(roomRequest.getRoomStatus());
        existingRoom.get().setDoctor(roomRequest.getDoctor());
        existingRoom.get().setPatient(roomRequest.getPatient());
        roomRepository.save(existingRoom.get());
    }

    @Override
    public RoomPageResponse getAllRooms(Integer page, Integer count) {
        Page<Room> roomPage = roomRepository.findAll(PageRequest.of(page, count));
        if (roomPage.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        }
        return new RoomPageResponse(
                roomPage.getContent().stream().map(roomMapper::toRoomResponse).collect(Collectors.toList()),
                roomPage.getTotalPages(),
                roomPage.getTotalElements(),
                roomPage.hasNext()
        );
    }

    @Override
    public RoomResponse getRoomByRoomNumber(Integer roomNumber) {
        return roomRepository.findById(roomNumber)
                .stream()
                .map(roomMapper::toRoomResponse)
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    @Override
    public List<RoomResponse> getRoomsByDoctorId(Integer doctorId) {
        List<Room> roomList = roomRepository.findByDoctor_Id(doctorId);
        if (roomList.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        }
        return roomList.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> getRoomsByDoctorFirstnameAndDoctorLastname(String firstname, String lastname) {
        List<Room> roomList = roomRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname, lastname);
        if (roomList.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        }
        return roomList.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());
    }

    @Override
    public RoomResponse getRoomByPatientId(Integer patientId) {
        return roomRepository.findByPatient_Id(patientId)
                .stream()
                .map(roomMapper::toRoomResponse)
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    @Override
    public RoomResponse getRoomByPatientFirstnameAndPatientLastname(String firstname, String lastname) {
        return roomRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname)
                .stream()
                .map(roomMapper::toRoomResponse)
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }


    @Override
    public void deleteRoomByRoomNumber(Integer roomNumber) {
        Optional<Room> room = roomRepository.findById(roomNumber);
        if (room.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        }
        roomRepository.deleteById(roomNumber);
    }

    @Override
    public boolean isAvailable(Status status) {
        switch (status) {
            case AVAILABLE -> {
                return true;
            }
            case OCCUPIED -> {
                return false;
            }
        }
        return false;
    }
}
