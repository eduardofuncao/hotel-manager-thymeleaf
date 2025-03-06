package br.com.fiap.hotel_manager.service;

import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.entity.Room;
import br.com.fiap.hotel_manager.mapper.RoomMapper;
import br.com.fiap.hotel_manager.repository.HotelRepository;
import br.com.fiap.hotel_manager.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomMapper roomMapper, RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public RoomDTO saveRoom(RoomDTO roomDTO) {
        Room roomToSave = roomMapper.toEntity(roomDTO);
        roomToSave.setHotel(hotelRepository.findById(roomDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("id de hotel não encontrado")));
        Room savedRoom = roomRepository.save(roomToSave);
        roomDTO.setId(savedRoom.getId());
        return roomDTO;
    }

    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO getRoomById(Long id) {
        Room foundRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return roomMapper.toDTO(foundRoom);
    }

    public void deleteRoomById(Long id) {
        Room roomToDelete = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        roomRepository.delete(roomToDelete);
    }
}
