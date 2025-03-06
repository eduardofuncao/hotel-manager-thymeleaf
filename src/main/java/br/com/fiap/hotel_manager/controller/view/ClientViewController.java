package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.ClientDTO;
import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientViewController {
    private final ClientService clientService;

    public ClientViewController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String clients(Model model) {
        List<ClientDTO> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "client/index";
    }

    @GetMapping("/new")
    public String newClient(Model model) {
        ClientDTO clientDTOtoAdd = new ClientDTO();
        model.addAttribute("client", clientDTOtoAdd);
        return "client/client-form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("client") ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
        return "redirect:/clients";
    }
}
