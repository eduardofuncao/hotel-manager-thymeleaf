package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setHotelId(room.getHotel().getId());
        return dto;
    }

    public Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setType(roomDTO.getType());
        room.setPrice(roomDTO.getPrice());
        return room;
    }
}
