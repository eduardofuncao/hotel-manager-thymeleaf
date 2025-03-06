package br.com.fiap.hotel_manager.controller.dto;

import br.com.fiap.hotel_manager.entity.Hotel;
import br.com.fiap.hotel_manager.entity.Reservation;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoomDTO {

    private Long id;

    private int roomNumber;
    private String type;
    private double price;

    private Long hotelId;
    private List<ReservationDTO> reservations;


    public ReservationDTO getNextReservation() {
        if (reservations == null || reservations.isEmpty()) {
            return null;
        }
        LocalDate minDate = reservations.stream()
                .map(ReservationDTO::getCheckinDate)
                .min(LocalDate::compareTo)
                .get();

        return reservations.stream()
                .filter(reservation -> reservation.getCheckinDate().equals(minDate))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no next reservation"));
    }

    public boolean isRoomAvailableNow() {
        LocalDate today = LocalDate.now();
        for (ReservationDTO reservation : reservations) {
            if (!reservation.getCheckinDate().isAfter(today) && !reservation.getCheckoutDate().isBefore(today)) {
                return false;
            }
        }
        return true;
    }


}
