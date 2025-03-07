package br.com.fiap.hotel_manager.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomDTO {

    private Long id;

    @NotNull(message = "room number is mandatory")
    private int roomNumber;
    private String type;
    @NotNull(message = "price is mandatory")
    private double price;

    @NotNull(message = "hotel id is mandatory")
    private Long hotelId;
    private List<ReservationDTO> reservations;


    public ReservationDTO getNextReservation() {
        if (reservations == null || reservations.isEmpty()) {
            return null;
        }
        List<ReservationDTO> filteredReservations = reservations.stream()
                .filter(reservationDTO -> reservationDTO.getCheckinDate().isAfter(LocalDate.now()))
                .toList();

        LocalDate minDate = filteredReservations.stream()
                .map(ReservationDTO::getCheckinDate)
                .min(LocalDate::compareTo)
                .orElse(LocalDate.now());


        return reservations.stream()
                .filter(reservation -> reservation.getCheckinDate().equals(minDate))
                .findFirst()
                .orElse(null);
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
