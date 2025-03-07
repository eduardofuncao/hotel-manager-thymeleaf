package br.com.fiap.hotel_manager.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationFullDetailsDTO {
    private Long id;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    private String clientName;
    private int roomNumber;
    private String hotelName;
}
