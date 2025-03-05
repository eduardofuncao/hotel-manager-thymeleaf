package br.com.fiap.hotel_manager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roomNumber;
    private String type;
    private double price;

    @OneToMany
    private List<Reservation> reservations;

    @ManyToOne
    private Hotel hotel;
}
