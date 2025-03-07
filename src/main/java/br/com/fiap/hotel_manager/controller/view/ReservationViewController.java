package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.ReservationDTO;
import br.com.fiap.hotel_manager.controller.dto.RoomDTO;
import br.com.fiap.hotel_manager.service.ClientService;
import br.com.fiap.hotel_manager.service.ReservationService;
import br.com.fiap.hotel_manager.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationViewController {

    private final ReservationService reservationService;
    private final RoomService roomService;
    private final ClientService clientService;

    public ReservationViewController(ReservationService reservationService, RoomService roomService, ClientService clientService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.clientService = clientService;
    }

    @GetMapping
    public String reservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservationsDetails());
        return "reservation/index";
    }

    @GetMapping("/new/roomid/{id}")
    public String newReservations(@PathVariable Long id, Model model) {
        ReservationDTO reservationDTOtoAdd = new ReservationDTO();
        reservationDTOtoAdd.setRoomId(id);
        model.addAttribute("reservation", reservationDTOtoAdd);
        model.addAttribute("clientIds", clientService.getAllClientIds());
        return "reservation/reservation-form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("reservation") @Valid ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
        RoomDTO roomDTO = roomService.getRoomById(reservationDTO.getRoomId());
        return "redirect:/hotels/" + roomDTO.getHotelId() + "/details";
    }


    @GetMapping("/{id}/cancel")
    public String cancelReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }
}
