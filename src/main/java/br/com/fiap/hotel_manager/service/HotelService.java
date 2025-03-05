package br.com.fiap.hotel_manager.service;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.entity.Hotel;
import br.com.fiap.hotel_manager.mapper.HotelMapper;
import br.com.fiap.hotel_manager.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private HotelMapper hotelMapper;
    private HotelRepository hotelRepository;

    public HotelService(HotelMapper hotelMapper, HotelRepository hotelRepository) {
        this.hotelMapper = hotelMapper;
        this.hotelRepository = hotelRepository;
    }


    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        Hotel savedHotel = hotelRepository.save(hotelMapper.toEntity(hotelDTO));
        hotelDTO.setId(savedHotel.getId());

        return hotelDTO;
    }

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotelById(Long id) {
        Hotel foundHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return hotelMapper.toDTO(foundHotel);
    }

    public void deleteHotelById(Long id) {
        Hotel hotelToDelete = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotelRepository.delete(hotelToDelete);
    }


}
