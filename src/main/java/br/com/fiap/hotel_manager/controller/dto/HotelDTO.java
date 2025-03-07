package br.com.fiap.hotel_manager.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

//TODO return rooms list in dto
@Data
public class HotelDTO {
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "address is mandatory")
    private String address;
    @NotBlank(message = "phone is mandatory")
    private String phone;
    private List<RoomDTO> rooms;

    public Integer getNumberOfAvailabeRooms() {
        int availableRooms = 0;
        for (RoomDTO room : rooms) {
            if (room.isRoomAvailableNow())
                availableRooms += 1;
        }
        return availableRooms;
    }
}
