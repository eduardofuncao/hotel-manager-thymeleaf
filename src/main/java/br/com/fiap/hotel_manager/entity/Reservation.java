package br.com.fiap.hotel_manager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Room room;
}
