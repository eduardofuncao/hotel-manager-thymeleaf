package br.com.fiap.hotel_manager.controller.dto;

import br.com.fiap.hotel_manager.entity.Hotel;
import br.com.fiap.hotel_manager.entity.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    private Long id;

    private int roomNumber;
    private Long hotelId;
}
