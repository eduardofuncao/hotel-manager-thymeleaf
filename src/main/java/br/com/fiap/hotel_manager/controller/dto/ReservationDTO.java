package br.com.fiap.hotel_manager.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationDTO {
    private Long id;

    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    private Long clientId;
    private Long roomId;
}
