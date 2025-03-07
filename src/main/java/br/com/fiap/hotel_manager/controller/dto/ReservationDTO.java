package br.com.fiap.hotel_manager.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationDTO {
    private Long id;

    @NotNull(message = "checkin date is mandatory")
    private LocalDate checkinDate;
    @NotNull(message = "checkout date is mandatory")
    private LocalDate checkoutDate;

    @NotNull(message = "client id date is mandatory")
    private Long clientId;
    @NotNull(message = "room id date is mandatory")
    private Long roomId;
}
