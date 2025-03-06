package br.com.fiap.hotel_manager.service;

import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.entity.Reservation;
import br.com.fiap.hotel_manager.mapper.ReservationMapper;
import br.com.fiap.hotel_manager.repository.ClientRepository;
import br.com.fiap.hotel_manager.repository.HotelRepository;
import br.com.fiap.hotel_manager.repository.ReservationRepository;
import br.com.fiap.hotel_manager.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservationToSave = reservationMapper.toEntity(reservationDTO);
        reservationToSave.setRoom(roomRepository.findById(reservationDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("id de quarto não encontrado")));
        reservationToSave.setClient(clientRepository.findById(reservationDTO.getClientId())
                .orElseThrow(() -> new RuntimeException(("id de cliente não encontrado"))));
        System.out.println(reservationToSave.getClient().getId());
        Reservation savedReservation = reservationRepository.save(reservationToSave);
        reservationDTO.setId(savedReservation.getId());
        return reservationDTO;
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation foundReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return reservationMapper.toDTO(foundReservation);
    }

    public void deleteReservationById(Long id) {
        Reservation reservationToDelete = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationRepository.delete(reservationToDelete);
    }
}
