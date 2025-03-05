package br.com.fiap.hotel_manager.repository;

import br.com.fiap.hotel_manager.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
