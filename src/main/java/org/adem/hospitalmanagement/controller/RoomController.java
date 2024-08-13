package org.adem.hospitalmanagement.controller;

import org.adem.hospitalmanagement.dto.page.RoomPageResponse;
import org.adem.hospitalmanagement.dto.request.RoomRequest;
import org.adem.hospitalmanagement.dto.response.RoomResponse;
import org.adem.hospitalmanagement.enums.Status;
import org.adem.hospitalmanagement.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add-room")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addRoom(@RequestBody RoomRequest roomRequest) {
        roomService.addRoom(roomRequest);
    }

    @PatchMapping("/update-room-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateRoomByRoomNumber(@RequestBody RoomRequest roomRequest, @PathVariable("id") Integer roomNumber) {
        roomService.updateRoomByRoomNumber(roomRequest,roomNumber);
    }

    @GetMapping("/get-all-rooms")
    @ResponseStatus(HttpStatus.OK)
    public RoomPageResponse getAllRooms(@RequestParam Integer page,@RequestParam Integer count) {
        return roomService.getAllRooms(page, count);
    }

    @GetMapping("/get-room-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByRoomNumber(@PathVariable("id") Integer roomNumber) {
        return roomService.getRoomByRoomNumber(roomNumber);
    }

    @GetMapping("/get-room-by-doctor-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomResponse> getRoomByDoctorId(@PathVariable("id") Integer doctorId) {
        return roomService.getRoomsByDoctorId(doctorId);
    }

    @GetMapping("/get-room-by-doctor-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomResponse> getRoomByDoctorFirstnameAndDoctorLastname(
            @RequestParam String firstname,@RequestParam String lastname) {
        return roomService.getRoomsByDoctorFirstnameAndDoctorLastname(firstname, lastname);
    }

    @GetMapping("/get-room-by-patient-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByPatientId(@PathVariable("id") Integer patientId) {
        return roomService.getRoomByPatientId(patientId);
    }

    @GetMapping("/get-room-by-patient-firstname-and-lastname")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByPatientFirstnameAndPatientLastname(
            @RequestParam String firstname,@RequestParam String lastname) {
        return roomService.getRoomByPatientFirstnameAndPatientLastname(firstname, lastname);
    }


    @DeleteMapping("/delete-room-by-room-number/{number}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteRoomByRoomNumber(@PathVariable("number") Integer rooNumber) {
        roomService.deleteRoomByRoomNumber(rooNumber);
    }


    @PostMapping("/is-available")
    @ResponseStatus(HttpStatus.OK)
    public boolean isAvailable(Status status){
        return roomService.isAvailable(status);
    }
}
