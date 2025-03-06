package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {


    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setCheckinDate(reservation.getCheckinDate());
        dto.setCheckoutDate(reservation.getCheckoutDate());
        dto.setClientId(reservation.getClient().getId());
        dto.setRoomId(reservation.getRoom().getId());
        return dto;
    }

    public Reservation toEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setCheckinDate(reservationDTO.getCheckinDate());
        reservation.setCheckoutDate(reservationDTO.getCheckoutDate());
        return reservation;
    }
}
