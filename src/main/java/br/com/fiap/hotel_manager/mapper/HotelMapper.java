package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//TODO create a custom mapper
@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDTO toDTO(Hotel hotel);

    Hotel toEntity(HotelDTO dto);
}
