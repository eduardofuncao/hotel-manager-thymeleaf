package br.com.fiap.hotel_manager.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO {
    private Long id;

    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;

    private Long clientId;
    private Long roomId;
}
