package br.com.fiap.hotel_manager.controller.dto;

import br.com.fiap.hotel_manager.entity.Reservation;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;

    private List<ReservationDTO> reservations;
}
