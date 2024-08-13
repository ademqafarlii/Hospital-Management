package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.RoomRequest;
import org.adem.hospitalmanagement.dto.response.RoomResponse;
import org.adem.hospitalmanagement.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoomEntity(RoomRequest roomRequest);
    RoomResponse toRoomResponse(Room room);
}
