package br.com.fiap.hotel_manager.entity;

import br.com.fiap.hotel_manager.repository.ReservationRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;

}
