package br.com.fiap.hotel_manager.repository;

import br.com.fiap.hotel_manager.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
