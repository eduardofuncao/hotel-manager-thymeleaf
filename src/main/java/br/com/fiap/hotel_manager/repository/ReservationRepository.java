package br.com.fiap.hotel_manager.repository;

import br.com.fiap.hotel_manager.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
