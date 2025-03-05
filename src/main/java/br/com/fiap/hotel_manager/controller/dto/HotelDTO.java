package br.com.fiap.hotel_manager.controller.dto;

import lombok.Data;

//TODO return rooms list in dto
@Data
public class HotelDTO {
    private Long id;

    private String name;
    private String address;
    private String phone;
}
