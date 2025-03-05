package br.com.fiap.hotel_manager.service;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.entity.Hotel;
import br.com.fiap.hotel_manager.mapper.HotelMapper;
import br.com.fiap.hotel_manager.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelMapper hotelMapper;
    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        Hotel savedHotel = hotelRepository.save(HotelMapper.INSTANCE.toEntity(hotelDTO));
        hotelDTO.setId(savedHotel.getId());
        return hotelDTO;
    }

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotelById(Long id) {
        Hotel foundHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return HotelMapper.INSTANCE.toDTO(foundHotel);
    }



}
