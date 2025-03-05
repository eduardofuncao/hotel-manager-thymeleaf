package br.com.fiap.hotel_manager.controller.dto;

import lombok.Data;

import java.util.List;

//TODO return rooms list in dto
@Data
public class HotelDTO {
    private Long id;

    private String name;
    private String address;
    private String phone;
    private List<RoomDTO> rooms;

    public Integer getNumberOfRooms() {
        if (rooms == null) {
            return 0;
        }
        return this.rooms.size();
    }
}
