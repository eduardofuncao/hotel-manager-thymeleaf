package br.com.fiap.hotel_manager.service;

import br.com.fiap.hotel_manager.controller.dto.ClientDTO;
import br.com.fiap.hotel_manager.entity.Client;
import br.com.fiap.hotel_manager.mapper.ClientMapper;
import br.com.fiap.hotel_manager.repository.HotelRepository;
import br.com.fiap.hotel_manager.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final HotelRepository hotelRepository;

    public ClientService(ClientMapper clientMapper, ClientRepository clientRepository, HotelRepository hotelRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
        this.hotelRepository = hotelRepository;
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client clientToSave = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(clientToSave);
        clientDTO.setId(savedClient.getId());
        return clientDTO;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        Client foundClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDTO(foundClient);
    }

    public void deleteClientById(Long id) {
        Client clientToDelete = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(clientToDelete);
    }
}
