package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.entity.Room;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomMapper {

    private final ReservationMapper reservationMapper = new ReservationMapper();

    public RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setHotelId(room.getHotel().getId());
        if (room.getReservations()!=null) {
            dto.setReservations(room.getReservations().stream()
                    .map(reservationMapper::toDTO)
                    .collect(Collectors.toList()));
        }
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
