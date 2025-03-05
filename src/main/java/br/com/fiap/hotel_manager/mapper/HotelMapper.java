package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.entity.Hotel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    RoomMapper roomMapper = new RoomMapper();

    public HotelDTO toDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setAddress(hotel.getAddress());
        dto.setPhone(hotel.getPhone());
        dto.setRooms(hotel.getRooms().stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public Hotel toEntity(HotelDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setName(dto.getName());
        hotel.setAddress(dto.getAddress());
        hotel.setPhone(dto.getPhone());
        return hotel;
    }
}
