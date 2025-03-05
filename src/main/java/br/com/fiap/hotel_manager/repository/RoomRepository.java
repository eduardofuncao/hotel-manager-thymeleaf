package br.com.fiap.hotel_manager.repository;

import br.com.fiap.hotel_manager.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
