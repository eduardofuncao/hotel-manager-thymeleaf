package br.com.fiap.hotel_manager.mapper;

import br.com.fiap.hotel_manager.controller.dto.ClientDTO;
import br.com.fiap.hotel_manager.entity.Client;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientMapper {

    private ReservationMapper reservationMapper = new ReservationMapper();

    public ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setReservations(client.getReservations().stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        return client;
    }
}
